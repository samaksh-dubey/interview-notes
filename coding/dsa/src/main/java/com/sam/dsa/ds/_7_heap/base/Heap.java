package com.sam.dsa.ds._7_heap.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Heap<T> {
  private final Vector<T> vector;
  private final Comparator<T> comparator;

  public Heap(Comparator<T> comparator) {
    this.vector = new Vector<>();
    this.comparator = comparator;
  }

  public Heap(T[] elements, Comparator<T> comparator) {
    this.vector = new Vector<>();
    this.comparator = comparator;
    vector.addAll(Arrays.asList(elements));
    heapify();
  }

  private void swap(int i, int j) {
    T temp = vector.get(i);
    vector.set(i, vector.get(j));
    vector.set(j, temp);
  }

  private void heapify() {
    int lastParent = HeapUtils.parent(vector.size() - 1);
    for (int i = lastParent; i >= 0; i--) heapifyDown(i);
  }

  private void heapifyDown(int i) {
    int next = i, right = HeapUtils.right(next), left = HeapUtils.left(i);

    if (left < vector.size() && comparator.compare(vector.get(next), vector.get(left)) >= 0)
      next = left;

    if (right < vector.size() && comparator.compare(vector.get(next), vector.get(right)) >= 0)
      next = right;

    if (next != i) {
      swap(i, next);
      heapifyDown(next);
    }
  }

  private void heapifyUp(int i) {
    int parent = HeapUtils.parent(i);
    if (i > 0 && comparator.compare(vector.get(parent), vector.get(i)) >= 0) {
      swap(i, parent);
      heapifyUp(parent);
    }
  }

  public void offer(T element) {
    this.vector.add(element);
    heapifyUp(this.vector.size() - 1);
  }

  public T poll() {
    if (this.vector.isEmpty()) return null;

    T top = this.vector.getFirst();
    swap(0, this.vector.size() - 1);
    this.vector.removeLast();
    heapifyDown(0);
    return top;
  }

  public T peek() {
    if (this.vector.isEmpty()) return null;

    return this.vector.getFirst();
  }

  public boolean isEmpty() {
    return this.vector.isEmpty();
  }

  @Override
  public String toString() {
    return this.vector.toString();
  }
}
