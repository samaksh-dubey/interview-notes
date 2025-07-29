package com.sam.dsa.ds._1_sorting.base;

// Utilize two logics
// 1. partition logic to return the pivot index (p)
// 2. sort logic to recursively call sort on low, p-1 and p+1 to high
public class QuickSortLomuto {

  public static void sort(int[] arr, int low, int high) {
    if (high <= low) return;

    int pivot = partition(arr, low, high);
    sort(arr, low, pivot - 1);
    sort(arr, pivot + 1, high);
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int pIndex = low;
    for (int i = low; i < high; i++) {
      if (arr[i] <= pivot) {
        swap(arr, i, pIndex);
        pIndex++;
      }
    }
    swap(arr, high, pIndex);
    return pIndex;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[i] = temp;
  }
}
