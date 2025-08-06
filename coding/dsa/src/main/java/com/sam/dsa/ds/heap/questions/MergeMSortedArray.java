package com.sam.dsa.ds.heap.questions;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

public class MergeMSortedArray {

  // Node to store the data
  // list in which the data is stored
  // index in the list at which the data is stored
  private static class Node {
    @Getter @Setter private int data;
    @Getter @Setter private int index;
    @Getter private final int list;

    public Node(int data, int index, int list) {
      this.data = data;
      this.index = index;
      this.list = list;
    }
  }

  static List<Integer> sort(List<List<Integer>> lists) {
    // initialize a min-heap
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getData));

    // add the first element of every list in the min-heap in the node form
    for (int i = 0; i < lists.size(); i++) {
      queue.add(new Node(lists.get(i).getFirst(), 0, i));
    }

    // list to store the sorted result
    List<Integer> result = new ArrayList<>();

    while (!queue.isEmpty()) {
      // poll the minimum in heap
      Node node = queue.poll();
      // add minimum to list
      result.add(node.getData());

      // find the list to which this minimum element belongs and the nextIndex of data element in
      // the list
      int minList = node.getList(), nextIndex = node.getIndex() + 1;

      // see if there are elements remaining in the list
      if (nextIndex < lists.get(minList).size()) {
        // if list contains more elements, then put the next element in the node
        node.setData(lists.get(minList).get(nextIndex));
        node.setIndex(nextIndex);

        // add the node in the heap again
        queue.add(node);
      }
    }

    return result;
  }
}
