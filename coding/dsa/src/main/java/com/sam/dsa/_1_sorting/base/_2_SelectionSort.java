package com.sam.dsa._1_sorting.base;

// Logic:
// 1. Divide array into two parts = sorted + unsorted
// 2. Find smallest element position in unsorted array
// 3. Swap first element with smallest element in unsorted array
// 4. Increment unsorted array
public class _2_SelectionSort {

  public static void selectionSort(int[] arr) {
    // run `n-1` times, where `n` is array length
    for (int i = 0; i < arr.length - 1; i++) {
      // find the minimum element in the unsorted subarray `[i…n-1]`
      // and swap it with `arr[i]`
      int min = i;

      for (int j = i + 1; j < arr.length; j++) {
        // if `arr[j]` is less, then it is the new minimum
        if (arr[j] < arr[min]) {
          min = j; // update the index of minimum element
        }
      }

      // swap the minimum element in subarray `arr[i…n-1]` with `arr[i]`
      swap(arr, min, i);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
