package com.sam.ds.algo.practise.heap.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Heap<T> {
  private final Vector<T> vector;
  private final Comparator<T> comparator;

  public Heap (Comparator<T> comparator) {
    this.vector = new Vector<>();
    this.comparator = comparator;
  }

  public Heap (T[] elements, Comparator<T> comparator) {
    this.vector = new Vector<>();
    this.comparator = comparator;
    vector.addAll(Arrays.asList(elements));
    heapify();
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int left(int i) {
    return 2 * i + 1;
  }

  private int right(int i) {
    return 2 * i + 2;
  }

  private void swap(int i, int j) {
    T temp = vector.get(i);
    vector.set(i, vector.get(j));
    vector.set(j, temp);
  }

  private void heapify() {
    int lastParent = parent(vector.size() - 1);
    for (int i = lastParent; i >= 0; i--)
      heapifyDown(i);
  }

  private void heapifyDown(int i) {
    int next = i, right = right(next), left = left(i);

    if (left < vector.size() && comparator.compare(vector.get(next), vector.get(left)) >= 0)
      next = left;

    if (right < vector.size() && comparator.compare(vector.get(next), vector.get(right)) >= 0)
      next = right;

    if (next != i) {
      swap(i ,next);
      heapifyDown(next);
    }
  }

  private void heapifyUp(int i) {
    int parent = parent(i);
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
    if (this.vector.isEmpty())
      return null;

    T top = this.vector.get(0);
    swap(0, this.vector.size() - 1);
    this.vector.remove(this.vector.size() - 1);
    heapifyDown(0);
    return top;
  }

  public T peek() {
    if (this.vector.isEmpty())
      return null;

    return this.vector.get(0);
  }

  public boolean isEmpty() {
    return this.vector.isEmpty();
  }

  @Override
  public String toString() {
    return this.vector.toString();
  }
}
