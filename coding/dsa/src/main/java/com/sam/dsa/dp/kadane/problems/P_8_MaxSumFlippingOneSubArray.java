package com.sam.dsa.dp.kadane.problems;

import com.sam.dsa.dp.kadane.base.Kadane;
import java.util.Arrays;

public class P_8_MaxSumFlippingOneSubArray {

  static int maxSum(int[] arr) {
    int totalSum = Arrays.stream(arr).sum();
    for (int i = 0; i < arr.length; i++) arr[i] = -arr[i];
    int minSum = Kadane.DP.maxSumSubArray(arr);
    return totalSum + 2 * minSum;
  }

  public static void main(String[] args) {
    System.out.println(maxSum(new int[] {-2, 3, -1, -4, -2}));
  }
}
