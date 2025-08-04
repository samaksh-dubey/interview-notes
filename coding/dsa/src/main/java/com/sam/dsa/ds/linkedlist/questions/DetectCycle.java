package com.sam.dsa.ds.linkedlist.questions;

import com.sam.dsa.ds.linkedlist.base.Node;

public class DetectCycle {

  public static boolean hasCycle(Node head) {
    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) return true;
    }

    return false;
  }
}
