package com.sam.dsa.algo.dp.kadane.problems;

public class P_4_MaxSumRemovingOneSubArray {

  static int max(int[] arr) {
    int n = arr.length;
    int[] preSums = new int[n], postSums = new int[n + 1];
    int preSum = 0, maxPreSum = 0, postSum = 0, maxPostSum = 0;

    for (int i = 0; i < n; i++) {
      preSum = Math.max(preSum + arr[i], arr[i]);
      postSum = Math.max(postSum + arr[n - i - 1], arr[n - i - 1]);
      preSums[i] = maxPreSum = Math.max(preSum, maxPreSum);
      postSums[n - i - 1] = maxPostSum = Math.max(postSum, maxPostSum);
    }
    int max = 0;
    for (int i = 0; i < n; i++) max = Math.max(max, preSums[i] + postSums[i]);
    return max;
  }

  public static void main(String[] args) {
    System.out.println(max(new int[] {7, 6, -1, -4, -5, 7, 1}));
  }
}
