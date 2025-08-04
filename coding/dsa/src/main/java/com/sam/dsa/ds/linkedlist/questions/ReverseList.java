package com.sam.dsa.ds.linkedlist.questions;

import com.sam.dsa.ds.linkedlist.base.Node;
import java.util.Objects;

public class ReverseList {

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
