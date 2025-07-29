package com.sam.dsa.ds._2_linkedlist.questions;

import com.sam.dsa.ds._2_linkedlist.base.Node;

public class _12_DetectCycle {

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
