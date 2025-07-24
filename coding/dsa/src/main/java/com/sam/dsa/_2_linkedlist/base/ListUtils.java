package com.sam.dsa._2_linkedlist.base;

public class ListUtils {

  public static void print(Node head) {
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }

    System.out.print("null\n");
  }

  public static int length(Node head) {
    int n = 0;
    while (head != null) {
      head = head.next;
      n = n + 1;
    }
    return n;
  }
}
