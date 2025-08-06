package com.sam.dsa.ds.heap.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import lombok.Getter;
import lombok.Setter;

public class MergeMSortedLinkedList {

  private static class Node {
    @Getter private final int data;
    @Getter @Setter private Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  static Node sort(Node[] lists) {
    Node dummyHead = new Node(0);
    Node current = dummyHead;
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getData));

    queue.addAll(Arrays.asList(lists));

    while (!queue.isEmpty()) {
      Node min = queue.poll();
      Node minNode = new Node(min.getData());

      current.setNext(minNode);
      current = current.getNext();

      if (min.next != null) queue.add(min.getNext());
    }

    return dummyHead.getNext();
  }
}
