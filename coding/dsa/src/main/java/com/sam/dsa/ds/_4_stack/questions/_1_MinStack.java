package com.sam.dsa.ds._4_stack.questions;

import java.util.Stack;

public class _1_MinStack {
  private final Stack<Integer> stack;
  private Integer min;

  public _1_MinStack() {
    this.stack = new Stack<>();
    this.min = null;
  }

  public void push(Integer val) {
    if (stack.isEmpty()) {
      stack.push(val);
      min = val;
    } else if (min <= val) {
      stack.push(val);
    } else {
      stack.push(2 * val - min);
      min = val;
    }
  }

  public int pop() {
    if (stack.isEmpty()) throw new RuntimeException("Underflow");

    if (min <= stack.peek()) return stack.pop();

    int val = min;
    min = 2 * min - stack.pop();

    return val;
  }

  public int peek() {
    if (stack.isEmpty()) throw new RuntimeException("Underflow");

    if (min > stack.peek()) return min;
    return stack.peek();
  }

  public int min() {
    if (stack.isEmpty()) throw new RuntimeException("Underflow");
    return min;
  }
}
