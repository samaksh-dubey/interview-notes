package com.sam.dsa.ds._2_linkedlist.questions;

import com.sam.dsa.ds._2_linkedlist.base.Node;
import java.util.Objects;

public class SplitList {

  public static Node split(Node head) {
    if (Objects.isNull(head)) return null;

    Node slow = head, fast = head;

    while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
      slow = slow.next;
      fast = fast.next.next;
    }

    Node res = slow.next;
    slow.next = null;
    return res;
  }
}
