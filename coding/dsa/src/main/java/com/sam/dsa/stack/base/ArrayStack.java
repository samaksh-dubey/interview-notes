package com.sam.dsa.stack.base;

public class ArrayStack {
  private final int[] arr;
  private final int SIZE;
  private int top;

  ArrayStack(int SIZE) {
    this.arr = new int[SIZE];
    this.SIZE = SIZE;
    top = -1;
  }

  boolean isEmpty() {
    return top == -1;
  }

  boolean isFull() {
    return top + 1 == SIZE;
  }

  int size() {
    return top + 1;
  }

  void push(int key) {
    if (isFull()) throw new RuntimeException("Overflow");

    arr[++top] = key;
  }

  int peek() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    return arr[top];
  }

  int pop() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    return arr[top--];
  }
}
