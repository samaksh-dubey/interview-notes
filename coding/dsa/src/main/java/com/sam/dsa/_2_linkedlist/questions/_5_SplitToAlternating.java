package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Objects;

// https://www.techiedelight.com/split-linked-list-into-two-lists-list-containing-alternating-elements/
// No need to maintain original ordering
public class _5_SplitToAlternating {

  public static Node[] alternatingSplit(Node source) {
    Node a = null;
    Node b = null;
    Node current = source;

    while (Objects.nonNull(current)) {
      Node newNode = current;
      current = current.next;

      newNode.next = a;
      a = newNode;

      if (Objects.nonNull(current)) {
        newNode = current;
        current = current.next;

        newNode.next = b;
        b = newNode;
      }
    }

    return new Node[] {a, b};
  }
}
