package com.sam.dsa.ds.linkedlist.questions;

import com.sam.dsa.ds.linkedlist.base.Node;
import java.util.Objects;

public class SortedInsert {

  public static Node sortedInsert(Node head, int val) {
    Node current = head, prev = null;

    while (current != null && current.val < val) {
      prev = current;
      current = current.next;
    }

    if (Objects.isNull(prev)) {
      prev = new Node(val);
      prev.next = head;
      return prev;
    } else {
      prev.next = new Node(val);
      prev.next.next = current;
      return head;
    }
  }
}
