package com.sam.dsa.ds._2_linkedlist.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _12_FlattenMultiLevelList {
  private static class Node {
    int val;
    Node next, child;

    public Node(int val) {
      this.val = val;
    }
  }

  public static Node flatten(Node head) {
    if (head == null) return null;

    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    Node dummy = new Node(0);
    Node current = dummy;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      while (node != null) {
        Node temp = node;
        node = node.next;
        temp.next = null;

        current.next = temp;
        current = current.next;

        if (temp.child != null) queue.add(temp.child);
      }
    }

    return dummy.next;
  }
}
