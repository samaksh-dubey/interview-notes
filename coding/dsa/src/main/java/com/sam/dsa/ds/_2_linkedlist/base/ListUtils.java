package com.sam.dsa.ds._2_linkedlist.base;

public class ListUtils {

  public static Node constructList(int[] keys) {
    Node head = null;

    for (int i = keys.length - 1; i >= 0; i--) {
      head = push(head, keys[i]);
    }
    return head;
  }

  public static int length(Node head) {
    int n = 0;
    while (head != null) {
      head = head.next;
      n = n + 1;
    }
    return n;
  }

  public static void print(Node head) {
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }

    System.out.print("null\n");
  }
}
