package com.sam.dsa.ds._4_stack.questions;

import java.util.Stack;

public class _7_SortStack {
  private final Stack<Integer> stack;

  public _7_SortStack() {
    this.stack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.peek();
  }

  public void sort() {
    if (stack.isEmpty()) return;

    int val = stack.pop();
    sort();
    sortedInsert(val);
  }

  private void sortedInsert(int val) {
    if (stack.isEmpty() || peek() < val) {
      stack.push(val);
      return;
    }

    int top = stack.pop();
    sortedInsert(val);
    stack.push(top);
  }
}
