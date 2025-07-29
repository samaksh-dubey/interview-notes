package com.sam.dsa.algo.arrays;

public class DutchNationalFlag {

  public static void sortArray(int[] nums) {
    int n = nums.length, low = 0, mid = 0, high = n;
    while (mid < high) {
      switch (nums[mid]) {
        case 0:
          swap(nums, low++, mid++);
          break;
        case 1:
          mid++;
          break;
        case 2:
          swap(nums, mid, --high);
          break;
      }
    }
    System.out.printf("hi");
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    sortArray(new int[] {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0});
  }
}
