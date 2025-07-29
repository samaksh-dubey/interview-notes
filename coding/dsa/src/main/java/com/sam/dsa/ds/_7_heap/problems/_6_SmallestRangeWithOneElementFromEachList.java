package com.sam.dsa.ds._7_heap.problems;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import lombok.Getter;
import lombok.Setter;

public class _6_SmallestRangeWithOneElementFromEachList {

  static class Node {
    @Getter @Setter private int data, index;
    @Getter private final int list;

    public Node(int data, int index, int list) {
      this.data = data;
      this.index = index;
      this.list = list;
    }
  }

  static int[] minRange(List<List<Integer>> lists) {
    // variable to keep track of highest element found so far in the heap
    int max = Integer.MIN_VALUE;

    // initialize a min heap and store the first elements of every list
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getData));
    for (int i = 0; i < lists.size(); i++) {
      queue.add(new Node(lists.get(i).getFirst(), 0, i));
      max = Math.max(max, lists.get(i).getFirst());
    }

    int[] result = new int[] {0, Integer.MAX_VALUE};

    while (true) {
      Node node = queue.poll();

      assert node != null;

      int min = node.getData();
      int list = node.getList();
      int nextIndex = node.getIndex() + 1;

      // update the result if the range is lower than the previous range
      if (max - min < result[1] - result[0]) {
        result = new int[] {min, max};
      }

      // return if one of the list is exhausted
      if (nextIndex == lists.get(list).size()) {
        return result;
      }

      // set the values of next element in the list to node
      node.setData(lists.get(list).get(nextIndex));
      node.setIndex(nextIndex);

      // add node back to heap
      queue.add(node);

      // reevaluate max value
      max = Math.max(max, lists.get(list).get(nextIndex));
    }
  }
}
