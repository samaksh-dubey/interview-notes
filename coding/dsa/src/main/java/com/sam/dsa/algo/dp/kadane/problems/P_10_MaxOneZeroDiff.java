package com.sam.dsa.algo.dp.kadane.problems;

import com.sam.dsa.algo.dp.kadane.base.Kadane;

public class P_10_MaxOneZeroDiff {

  static int max(int[] A) {
    int N = A.length;

    for (int i = 0; i < N; i++) if (A[i] == 0) A[i] = -1;

    int m1 = Kadane.DP.maxSumSubArray(A);

    for (int i = 0; i < N; i++) A[i] = -A[i];

    int m2 = Kadane.DP.maxSumSubArray(A);

    return Math.max(m1, m2);
  }

  public static void main(String[] args) {
    System.out.println(max(new int[] {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1}));
    System.out.println(max(new int[] {1, 1, 1, 1}));
  }
}
