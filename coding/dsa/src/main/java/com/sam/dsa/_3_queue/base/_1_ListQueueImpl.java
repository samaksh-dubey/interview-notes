package com.sam.dsa._3_queue.base;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

public class _1_ListQueueImpl {

  private static class Node {
    @Getter private int val;
    @Getter @Setter private Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node front, end;

  public _1_ListQueueImpl() {
    this.front = null;
    this.end = null;
  }

  public void add(int val) {
    Node node = new Node(val);
    if (Objects.isNull(front)) {
      front = node;
      end = node;
      return;
    }

    end.setNext(node);
    end = end.getNext();
  }

  public int poll() {
    if (Objects.isNull(front)) throw new RuntimeException("Underflow");

    int val = front.getVal();
    front = front.getNext();

    if (Objects.isNull(front)) {
      end = null;
    }

    return val;
  }
}
