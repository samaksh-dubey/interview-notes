package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

public class _9_ReverseList {

  public static Node reverse(Node head) {
    Node reversed = null;

    while (Objects.nonNull(head)) {
      Node next = head;
      head = head.next;

      next.next = reversed;
      reversed = next;
    }

    return reversed;
  }
}
