package com.sam.dsa.ds._1_sorting.questions;

// https://www.techiedelight.com/rearrange-array-positive-negative-numbers-alternate-positions/
public class RearrangePositiveNegative {

  public static void rearrange(int[] arr) {
    int pIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) swap(arr, i, pIndex++);
    }

    for (int i = 0; i < arr.length && pIndex < arr.length; i = i + 2, pIndex++) {
      swap(arr, i, pIndex);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
