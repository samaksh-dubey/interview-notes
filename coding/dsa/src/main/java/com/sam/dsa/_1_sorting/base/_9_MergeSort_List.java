package com.sam.dsa._1_sorting.base;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

public class _9_MergeSort_List {

  private static class Node {
    @Getter @Setter int val;
    @Getter @Setter Node next;

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder().append('[');
      Node curr = this;
      while (curr != null) {
        sb.append(curr.getVal()).append(',');
        curr = curr.getNext();
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
      return sb.toString();
    }
  }

  public static Node sort(Node node) {
    if (Objects.isNull(node) || Objects.isNull(node.getNext())) return node;

    Node mid = findMid(node);
    Node l1 = node;

    Node l2 = mid.getNext();
    mid.setNext(null);

    l1 = sort(l1);
    l2 = sort(l2);

    return merge(l1, l2);
  }

  private static Node merge(Node l1, Node l2) {
    Node res = new Node(0);
    Node curr = res;
    while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
      if (l1.getVal() < l2.getVal()) {
        curr.setNext(l1);
        l1 = l1.getNext();
      } else {
        curr.setNext(l2);
        l2 = l2.getNext();
      }
      curr = curr.getNext();
    }

    if (Objects.isNull(l1)) curr.setNext(l2);

    if (Objects.isNull(l2)) curr.setNext(l1);

    return res.getNext();
  }

  private static Node findMid(Node node) {
    Node slow = node, fast = node;
    while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    return slow;
  }
}
