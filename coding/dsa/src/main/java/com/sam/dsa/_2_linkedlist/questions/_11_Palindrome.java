package com.sam.dsa._2_linkedlist.questions;

import com.sam.dsa._2_linkedlist.base.Node;
import java.util.Stack;

public class _11_Palindrome {

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
