package com.sam.dsa.algo.dp.kadane.problems;

import java.util.TreeSet;

public class P_1_MaxSumLessThanK {
  static int maxSumSubArrayLessThanK(final int[] A, final int K) {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    int max = Integer.MIN_VALUE, sum = 0;
    for (int a : A) {
      sum = sum + a;
      Integer prev_sum = set.ceiling(sum - K);
      if (prev_sum != null) max = Math.max(max, sum - prev_sum);
      set.add(sum);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxSumSubArrayLessThanK(new int[] {5, -2, 6, 3, -5}, 15));
  }
}
