package com.sam.ds.algo.practise.heap.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedArray {

  static void sort(int[] A, int K) {
    int N = A.length, j = 0;
    if (N == 0)
      return;

    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    for (int i = 0; i < K + 1; i++)
      heap.offer(A[i]);

    for (int i = K + 1; i < N; i++) {
      A[j++] = heap.poll();
      heap.offer(A[i]);
    }

    while (!heap.isEmpty())
      A[j++] = heap.poll();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
    int k = 2;
    sort(arr, k);
    System.out.println(Arrays.toString(arr));
  }
}
