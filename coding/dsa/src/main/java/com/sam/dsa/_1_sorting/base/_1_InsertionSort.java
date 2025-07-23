package com.sam.dsa._1_sorting.base;

// Logic:
//
// 1. Array divided into two parts - sorted + unsorted denoted by single pointer unsorted
// 2. Take first element of unsorted part and insert it into the right position in sorted part
//    (This happens inside a nested loop and right after this loop)
// 3. Increment unsorted pointer
public class _1_InsertionSort {

  public static void sort(int[] arr, int len) {
    for (int i = 1; i < len; i++) {
      int value = arr[i];
      int j = i;

      // find index `j` within the sorted subset `arr[0…i-1]`
      // where element `arr[i]` belongs
      while (j > 0 && arr[j - 1] > value) {
        arr[j] = arr[j - 1];
        j--;
      }

      // note that the subarray `arr[j…i-1]` is shifted to
      // the right by one position, i.e., `arr[j+1…i]`
      arr[j] = value;
    }
  }
}
