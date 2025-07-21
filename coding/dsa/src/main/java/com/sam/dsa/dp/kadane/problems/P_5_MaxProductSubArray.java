package com.sam.dsa.dp.kadane.problems;

public class P_5_MaxProductSubArray {

  static int maxProduct(int[] arr) {
    int n = arr.length;
    int max_ending_here = arr[0], min_ending_here = arr[0], max_so_far = arr[0];

    for (int i = 1; i < n; i++) {
      int temp = Math.max(arr[i], Math.max(arr[i] * max_ending_here, arr[i] * min_ending_here));
      min_ending_here =
          Math.min(arr[i], Math.min(arr[i] * max_ending_here, arr[i] * min_ending_here));
      max_ending_here = temp;
      max_so_far = Math.max(max_so_far, max_ending_here);
    }

    return max_so_far;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] {3, 0, 2}));
    System.out.println(maxProduct(new int[] {0, 2}));
    System.out.println(maxProduct(new int[] {-1, -2, 0}));
    System.out.println(maxProduct(new int[] {-1, 0}));
    System.out.println(maxProduct(new int[] {-5, -1, -3}));
  }
}
