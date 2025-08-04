package com.sam.dsa.ds.linkedlist.questions;

import com.sam.dsa.ds.linkedlist.base.Node;
import java.util.Stack;

public class Palindrome {

  public static boolean isPalindrome(Node head) {
    if (head == null) return true;

    Stack<Node> stack = new Stack<>();
    Node current = head;
    while (current != null) {
      stack.push(current);
      current = current.next;
    }

    while (stack.isEmpty()) {
      if (stack.pop().val != head.val) return false;
      head = head.next;
    }

    return true;
  }
}
