package com.sam.dsa.ds.sorting.base;

// Logic:
// 1. Compare the element with its next element and if in wrong order then swap the element
// 2. Reduce the window by 1
public class BubbleSort {

  public static void sort(int[] arr, int length) {
    for (int window = length; window > 0; window--) {
      // iterate in unsorted window
      for (int j = 0; j < window - 1; j++) {
        // swap if element in wrong order
        if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
