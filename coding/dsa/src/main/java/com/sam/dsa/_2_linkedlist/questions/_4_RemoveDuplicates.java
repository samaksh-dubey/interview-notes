package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

public class _4_RemoveDuplicates {

  public static void removeDuplicates(Node head) {
    if (Objects.isNull(head)) return;

    Node current = head;
    while (Objects.nonNull(current)) {
      Node next = current.next;
      while (Objects.nonNull(next) && next.val == current.val) next = next.next;

      current.next = next;
      current = current.next;
    }
  }
}
