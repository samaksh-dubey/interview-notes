package com.sam.ds.algo.practise.heap.problems;

import java.util.Arrays;

public class HeapSort {

  static void sort(int[] arr) {
    heapify(arr);
    int N = arr.length;
    for (int i = 0; i < N; i++) {
      Integer element = poll(arr, N - i);
      if (element != null)
        arr[N - i - 1] = element;
    }
  }

  private static Integer poll(int[] arr, int size) {
    if (size < 0)
      return null;

    int first = arr[0];
    int last = arr[size - 1];

    arr[0] = last;
    heapify_down(arr, 0, size - 1);

    return first;
  }

  static void heapify(int[] arr) {
    int N = arr.length;
    int i = (N - 2) / 2;

    while (i >= 0) {
      heapify_down(arr, i--, N);
    }
  }

  static void heapify_down(int[] arr, int i, int size) {
    if (i >= size)
      return;

    int largest = i;

    if (left(i) < size && arr[left(i)] > arr[largest])
      largest = left(i);

    if (right(i) < size && arr[right(i)] > arr[largest])
      largest = right(i);

    if (largest != i) {
      swap(arr, i, largest);
      heapify_down(arr, largest, size);
    }
  }

  static int left(int i) {
    return 2 * i + 1;
  }

  static int right(int i) {
    return 2 * i + 2;
  }

  static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}
