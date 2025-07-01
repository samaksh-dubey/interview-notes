package com.sam.ds.algo.practise.heap.problems;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeWithOneElementFromEachList {

  static class Node implements Comparable<Node> {
    int data, index, list;

    public Node(int data, int index, int list) {
      this.data = data;
      this.index = index;
      this.list = list;
    }

    @Override
    public int compareTo(Node o) {
      return this.data - o.data;
    }
  }

  static class Pair {
    int high, low;

    public Pair(int high, int low) {
      this.high = high;
      this.low = low;
    }

    @Override
    public String toString() {
      return "{" + low + "," + high + "}";
    }
  }

  static Pair minRange(List<List<Integer>> lists) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i).isEmpty())
        return new Pair(-1, -1);
      else
        queue.add(new Node(lists.get(i).get(0), 0, i));
    }

    int high = Integer.MIN_VALUE;
    Pair result = new Pair(Integer.MAX_VALUE, 0);

    while (true) {
      Node min = queue.poll();

      int low = min.data;
      int list = min.list;
      int index = min.index;

      if (high - low < result.high - result.low)
        result = new Pair(high, low);

      if (index + 1 == lists.get(list).size())
        return result;

      min.data = lists.get(list).get(index + 1);
      min.index = index + 1;
      queue.add(min);

      high = Math.max(high, lists.get(list).get(index + 1));
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> lists = Arrays.asList(
        Arrays.asList(3, 6, 8, 10, 15),
        Arrays.asList(1, 5, 12),
        Arrays.asList(4, 8, 15, 16),
        Arrays.asList(2, 6)
    );

    System.out.println("The minimum range is " + minRange(lists));
  }
}
