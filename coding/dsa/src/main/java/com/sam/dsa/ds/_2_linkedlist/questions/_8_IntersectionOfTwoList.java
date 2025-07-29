package com.sam.dsa.ds._2_linkedlist.questions;

import com.sam.dsa.ds._2_linkedlist.base.Node;
import java.util.Objects;

public class _8_IntersectionOfTwoList {

  public static Node intersection(Node h1, Node h2) {
    Node dummy = new Node(0);
    Node current = dummy;

    while (Objects.nonNull(h1) && Objects.nonNull(h2)) {
      if (h1.val < h2.val) {
        h1 = h1.next;
      } else if (h1.val > h2.val) {
        h2 = h2.next;
      } else {
        current.next = new Node(h1.val);
        current = current.next;

        h1 = h1.next;
        h2 = h2.next;
      }
    }

    return dummy.next;
  }
}
