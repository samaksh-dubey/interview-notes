package com.sam.dsa.dp.knapsack.problems;

import java.util.Arrays;

/** Given: Integer array = arr Difference of two subset of array = diff */
public class P_5_CountSubsetWithGivenDifference {
  static int countSubsetWithGivenDiff(int[] arr, int diff) {
    int TOTAL = Arrays.stream(arr).sum();
    int N = arr.length, SUM = (TOTAL + diff) / 2;
    return P_3_CountSubsetWithSum.DP.countSubsetSum(arr, N, SUM);
  }
}
