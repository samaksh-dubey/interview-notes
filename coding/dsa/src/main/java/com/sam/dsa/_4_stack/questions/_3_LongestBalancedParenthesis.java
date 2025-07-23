package com.sam.dsa._4_stack.questions;

import java.util.Stack;

public class _3_LongestBalancedParenthesis {
  private static class Node {
    char ch;
    int index;

    public Node(char ch, int index) {
      this.ch = ch;
      this.index = index;
    }
  }

  public static int longestBalancedParenthesis(String expression) {
    char[] character = expression.toCharArray();
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int max = 0;

    for (int i = 0; i < character.length; i++) {
      if (character[i] != ')') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          max = Math.max(max, i - stack.peek());
        }
      }
    }

    return max;
  }
}
