package com.sam.dsa._2_linkedlist.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

  private int val;
  private Node next;

  public Node(int val) {
    this.val = val;
  }
}
