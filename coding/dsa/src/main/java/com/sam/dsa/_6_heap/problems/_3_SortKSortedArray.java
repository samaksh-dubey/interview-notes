package com.sam.dsa._6_heap.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _3_SortKSortedArray {

  static void sort(int[] arr, int k) {
    int n = arr.length, j = 0;
    if (n == 0) return;

    // insert first K+1 elements into the array ->
    // this ensures that the element in sorted order at first index will be in heap
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    for (int i = 0; i < k + 1; i++) heap.offer(arr[i]);

    // iterate from K+1 index and populate the elements in array from start
    // put (K+1)th index element in heap
    for (int i = k + 1; i < n; i++) {
      arr[j++] = heap.poll();
      heap.offer(arr[i]);
    }

    // insert remaining elements from heap to array
    while (!heap.isEmpty()) arr[j++] = heap.poll();
  }
}
