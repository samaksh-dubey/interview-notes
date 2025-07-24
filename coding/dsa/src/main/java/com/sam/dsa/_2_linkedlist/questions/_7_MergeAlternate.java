package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

public class _7_MergeAlternate {

  public static Node merge(Node l1, Node l2) {
    Node head = new Node(0);
    Node current = head;

    while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
      Node n1 = l1, n2 = l2;
      l1 = l1.next;
      l2 = l2.next;

      n1.next = null;
      n2.next = null;

      current.next = n1;
      current.next.next = n2;

      current = current.next.next;
    }

    if (Objects.isNull(l1)) current.next = l2;

    if (Objects.isNull(l2)) current.next = l1;

    return head.next;
  }
}
