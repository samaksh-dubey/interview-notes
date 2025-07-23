package com.sam.dsa._2_linkedlist.base;

public class ListUtils {

  public static void print(Node head) {
    while (head != null) {
      System.out.println(head.getVal() + " -> ");
      head = head.getNext();
    }

    System.out.println("null");
  }
}
