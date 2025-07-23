package com.sam.dsa._1_sorting.questions;

// https://www.techiedelight.com/move-zeros-present-array-end/
public class _8_MoveZerosToEnd {

  public static void moveZero(int[] arr) {
    int pIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) swap(arr, i, pIndex++);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
