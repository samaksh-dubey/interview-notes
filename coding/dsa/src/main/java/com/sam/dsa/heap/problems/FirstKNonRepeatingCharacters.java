package com.sam.dsa.heap.problems;

import java.util.*;

public class FirstKNonRepeatingCharacters {

  private static class Node {
    int count;
    int lastIndex;

    void increment(int lastIndex) {
      this.lastIndex = lastIndex;
      this.count++;
    }
  }

  public static List<Character> findFirstKNonRepeating(String str, int k) {
    char[] input = str.toCharArray();
    int len = str.length();

    Map<Character, Node> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      map.computeIfAbsent(input[i], c -> new Node()).increment(i);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (Node value : map.values()) {
      if (value.count == 1) {
        if (pq.size() < k) {
          pq.add(value.lastIndex);
        } else if (value.lastIndex < pq.peek()) {
          pq.poll();
          pq.add(value.lastIndex);
        }
      }
    }

    List<Character> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(input[pq.poll()]);
    }

    return result;
  }

}
