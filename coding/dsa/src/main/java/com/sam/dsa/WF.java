package com.sam.dsa;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import lombok.Getter;

/** Longest Consecutive Zeros Sub array less than size K */
public class WF {

  public static int max(List<Integer> encrypted, List<Integer> binary, int k) {
    int oneSum = 0, zeroSum = 0, max = 0, count = 0, beg = -1;

    for (int i = 0; i < encrypted.size(); i++) {
      if (binary.get(i) == 1) {
        oneSum = oneSum + encrypted.get(i);
        zeroSum = 0;
        count = 0;
        beg = i + 1;
      }

      if (binary.get(i) == 0) {
        zeroSum = zeroSum + encrypted.get(i);
        count++;
        if (count > k) {
          zeroSum = zeroSum - encrypted.get(beg++);
          count--;
        }
        max = Math.max(max, zeroSum);
      }
    }

    return oneSum + max;
  }

  public static void main(String[] args) {
    class Node {
      @Getter char ch;
      @Getter int index;

      Node(char ch, int index) {
        this.ch = ch;
        this.index = index;
      }
    }
    PriorityQueue<Node> pq =
        new PriorityQueue<Node>(
            Comparator.comparing(Node::getCh)
                .thenComparing(Comparator.comparing(Node::getIndex).reversed()));
  }
}
