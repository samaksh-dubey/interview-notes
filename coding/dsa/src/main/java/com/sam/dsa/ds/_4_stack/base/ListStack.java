package com.sam.dsa.ds._4_stack.base;

public class ListStack {

  private static class Node {
    private final int val;
    private Node next;

    Node(int val) {
      this.val = val;
    }
  }

  private Node top;
  private int size;

  boolean isEmpty() {
    return top == null;
  }

  int size() {
    return size;
  }

  void push(int key) {
    Node node = new Node(key);
    node.next = top;
    top = node;
    size++;
  }

  int peek() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    return top.val;
  }

  int pop() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    int val = top.val;
    top = top.next;
    size--;
    return val;
  }
}
