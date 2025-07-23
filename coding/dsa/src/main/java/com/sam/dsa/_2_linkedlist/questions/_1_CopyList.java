package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

public class _1_CopyList {

  public static Node copy(Node head) {
    Node dummy = new Node(0);

    Node current = dummy;
    while (Objects.nonNull(head)) {
      Node node = new Node(head.getVal());
      current.setNext(node);
      head = head.getNext();
      current = current.getNext();
    }

    return dummy.getNext();
  }
}
