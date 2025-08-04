package com.sam.dsa.ds.linkedlist.questions;

import com.sam.dsa.ds.linkedlist.base.Node;
import java.util.Objects;

public class CopyList {

  public static Node copy(Node head) {
    Node dummy = new Node(0);

    Node current = dummy;
    while (Objects.nonNull(head)) {
      Node node = new Node(head.val);
      current.next = node;
      head = head.next;
      current = current.next;
    }

    return dummy.next;
  }
}
