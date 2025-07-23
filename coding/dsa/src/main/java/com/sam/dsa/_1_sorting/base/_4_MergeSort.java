package com.sam.dsa._1_sorting.base;

import java.util.Arrays;

// Utilize divide and conquer.
// 1. break array into two equal parts recursively till there is only one element left
// 2. sort these parts individually and store the result in aux array
// 3. merge the sorted part before coming out of recursion utilising the sorted parts stored in aux
// array
public class _4_MergeSort {

  private static void sort(int[] arr, int length) {
    sort(arr, Arrays.copyOf(arr, length), 0, length - 1);
  }

  private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
    int i = low, k = low, j = mid + 1;

    while (i <= mid && j <= high) {
      if (aux[i] < aux[j]) arr[k++] = aux[i++];
      else arr[k++] = aux[j++];
    }

    while (i <= mid) arr[k++] = aux[i++];

    while (j <= high) arr[k++] = aux[j++];

    for (i = low; i <= high; i++) aux[i] = arr[i];
  }

  public static void sort(int[] arr, int[] aux, int low, int high) {
    if (high <= low) return;

    int mid = (low + high) / 2;

    sort(arr, aux, low, mid);
    sort(arr, aux, mid + 1, high);

    merge(arr, aux, low, mid, high);
  }
}
