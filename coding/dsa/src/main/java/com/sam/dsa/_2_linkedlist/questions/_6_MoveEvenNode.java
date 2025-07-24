package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

// Move even nodes to the end of the list in reverse order
// https://www.techiedelight.com/move-even-nodes-to-end-of-list-in-reverse-order/
public class _6_MoveEvenNode {

  public static void rearrange(Node head) {
    if (head == null) {
      return;
    }

    Node odd = head;
    Node even = null, prev = null;

    while (Objects.nonNull(odd) && Objects.nonNull(odd.next)) {
      if (Objects.nonNull(odd.next)) {
        Node newNode = odd.next;
        odd.next = odd.next.next;

        newNode.next = even;
        even = newNode;
      }

      prev = odd;
      odd = odd.next;
    }

    // append even list to odd list
    if (Objects.nonNull(odd)) {
      odd.next = even;
    } else {
      prev.next = even;
    }
  }
}
