package com.sam.dsa.ds._7_heap.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _2_KthLargestElement {

  static int kthLargest(int[] arr, int k) {
    // base case: if k = 0 or if k is more than the total elements
    if (k < 1 || k > arr.length) return Integer.MIN_VALUE;

    // initialize kLargest as minimum value
    int kLargest = Integer.MIN_VALUE;

    // initialize a min heap
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    // put first k elements in the min heap
    for (int i = 0; i < k; i++) {
      heap.add(arr[i]);
    }

    // start from (k+1)th element
    for (int i = k; i < arr.length; i++) {

      // if this element is more than the peek of min heap then remove peek and add this
      if (heap.peek() != null && arr[i] > heap.peek()) {
        heap.poll();
        heap.add(arr[i]);
      }
    }

    return kLargest;
  }
}
