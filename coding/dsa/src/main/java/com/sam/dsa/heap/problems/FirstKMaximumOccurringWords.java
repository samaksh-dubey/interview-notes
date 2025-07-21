package com.sam.dsa.heap.problems;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class FirstKMaximumOccurringWords {

  private static class Node {
    @Getter String word;
    @Getter int firstIndex, count;

    Node(String word, int firstIndex) {
      this.word = word;
      this.firstIndex = firstIndex;
      this.count = 0;
    }

    public void increaseCount() {
      this.count++;
    }
  }

  public static List<String> firstKMaxWords(String[] words, int k) {
    // store frequency of the word with its firs occurrence in the map
    Map<String, Node> map = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      final int index = i;
      map.computeIfAbsent(words[i], x -> new Node(words[index], index)).increaseCount();
    }

    // min heap to store the k largest elements till any index i
    PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));

    for (Node node: map.values()) {
      // for first k elements directly insert into the heap
      if (heap.size() < k)  {
        heap.add(node);
        continue;
      }

      assert heap.peek() != null;

      // for elements after kth index check if the count is greater than peek of min heap
      // if yes then insert
      if (node.getCount() > heap.peek().getCount()) {
        heap.poll();
        heap.add(node);
      }
    }

    // prepare result list
    List<String> result = new ArrayList<>();
    while (!heap.isEmpty())
      result.add(heap.poll().getWord());

    return result;
  }
}
