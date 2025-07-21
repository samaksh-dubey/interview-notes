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

    // store the indexes in a max heap (max size will be `k`)
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    // traverse the map and process index of all characters
    for (Node value : map.values()) {
      // only process non-repeating characters
      if (value.count == 1) {
        if (pq.size() < k) {
          // add first k characters
          pq.add(value.lastIndex);
          continue;
        }

        // add remaining character only if they appear before the current top
        if (value.lastIndex < pq.peek()) {
          pq.poll();
          pq.add(value.lastIndex);
        }
      }
    }

    List<Character> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.addFirst(input[pq.poll()]);
    }

    return result;
  }

}
