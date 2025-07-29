package com.sam.dsa.ds._2_linkedlist.questions;

import com.sam.dsa.ds._2_linkedlist.base.Node;
import java.util.Objects;

public class _10_ReverseKGroup {

  public static Node reverseKGroup(Node head, int k, int n) {
    if (Objects.isNull(head)) return head;

    k = k % n;
    int count = k == 0 ? n : k;

    Node reversed = null;

    while (Objects.nonNull(head) && count-- > 0) {
      Node next = head;
      head = head.next;

      next.next = reversed;
      reversed = next;
    }

    if (reversed == null) return reversed;

    Node current = reversed;
    while (Objects.nonNull(current.next)) current = current.next;

    current.next = reverseKGroup(head, k, n - k % n);

    return reversed;
  }
}
