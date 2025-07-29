package com.sam.dsa.algo.string;

import java.util.Stack;

public class _54_ReverseString {

  static void reverse(char[] string) {
    Stack<Character> stack = new Stack<>();

    for (char ch : string) {
      stack.push(ch);
    }

    int i = 0;
    while (!stack.isEmpty()) {
      string[i++] = stack.pop();
    }
  }
}
