package com.sam.ds.algo.practise.heap.base;

public class HeapUtils {

  // return the parent index of index i
  public static int parent(int child) {
    return (child - 1) / 2;
  }

  // return the left child index of parent
  public static int left(int parent) {
    return 2 * parent + 1;
  }

  // return the right child index of parent
  public static int right(int parent) {
    return 2 * parent + 2;
  }

  // check if given array is heap or not
  public static boolean isHeap(int[] arr) {
    if(arr == null || arr.length == 0)
      return true;

    return isHeap(arr, 0);
  }

  // check if given array is min-heap or not recursively
  private static boolean isHeap(int[] arr, int parent) {
    int left = HeapUtils.left(parent);
    int right = HeapUtils.right(parent);

    // Check invalid left child
    if (left < arr.length && arr[left] < arr[parent]) {
      return false;
    }

    // Check invalid right child
    if (right < arr.length && arr[right] < arr[parent]) {
      return false;
    }

    // Recursively check left and right subtrees
    return (left >= arr.length || isHeap(arr, left)) &&
        (right >= arr.length || isHeap(arr, right));
  }
}
