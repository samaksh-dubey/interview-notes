package com.sam.dsa._1_sorting.base;

// https://leetcode.com/problems/sort-colors/description/
// https://www.techiedelight.com/quicksort-using-dutch-national-flag-algorithm/
// https://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/
public class _10_DutchNationalFlag {

  public static void sort(int[] arr) {
    int lo = 0, mid = 0, hi = arr.length - 1;

    while (mid <= hi) {
      if (arr[mid] == 0) {
        swap(arr, lo++, mid++);
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, --hi);
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
