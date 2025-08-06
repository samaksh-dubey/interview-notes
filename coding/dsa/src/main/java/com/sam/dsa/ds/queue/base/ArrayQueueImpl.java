package com.sam.dsa.ds.queue.base;

public class ArrayQueueImpl {

  private int[] arr; // array to store queue elements
  private int front; // front points to the front element in the queue
  private int rear; // rear points to the last element in the queue
  private int capacity; // maximum capacity of the queue
  private int count; // current size of the queue

  ArrayQueueImpl(int size) {
    arr = new int[size];
    capacity = size;
    front = 0;
    rear = -1;
    count = 0;
  }

  public int dequeue() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    int x = arr[front];
    front = (front + 1) % capacity;
    count--;

    return x;
  }

  public void enqueue(int item) {
    if (isFull()) throw new RuntimeException("Overflow");

    rear = (rear + 1) % capacity;
    arr[rear] = item;
    count++;
  }

  public int peek() {
    if (isEmpty()) throw new RuntimeException("Underflow");

    return arr[front];
  }

  public int size() {
    return count;
  }

  public boolean isEmpty() {
    return (size() == 0);
  }

  public boolean isFull() {
    return (size() == capacity);
  }
}
