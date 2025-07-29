package com.sam.dsa.algo.dp.knapsack_unbounded.base;

import java.util.Arrays;

public class Knapsack_Unbounded {
  private static int max(int a, int b) {
    return Math.max(a, Math.max(b, b));
  }

  static class Recursive {
    static int unboundedKnapsack(int[] wt, int[] val, int cap, int n) {
      if (cap == 0 || n == 0) return 0;
      if (wt[n - 1] > cap) return unboundedKnapsack(wt, val, cap, n - 1);
      return max(
          unboundedKnapsack(wt, val, cap, n - 1),
          val[n - 1] + unboundedKnapsack(wt, val, cap - wt[n - 1], n));
    }
  }

  static class Memoize {
    static int unboundedKnapsack(int[] wt, int[] val, int cap, int n, int[][] dp) {
      if (cap == 0 || n == 0) return 0;
      if (dp[cap][n] != -1) return dp[cap][n];

      if (wt[n - 1] > cap) return dp[cap][n] = unboundedKnapsack(wt, val, cap, n - 1, dp);
      return dp[cap][n] =
          max(
              unboundedKnapsack(wt, val, cap, n - 1, dp),
              val[n - 1] + unboundedKnapsack(wt, val, cap - wt[n - 1], n, dp));
    }
  }

  static class DP {
    static int unboundedKnapsack(int[] wt, int[] val, final int CAP, final int N) {
      int[][] dp = new int[CAP + 1][N + 1];
      Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
      for (int cap = 0; cap < CAP + 1; cap++) {
        for (int n = 0; n < N; n++) {
          if (cap == 0 || n == 0) {
            dp[cap][n] = 0;
          } else if (wt[n - 1] > cap) {
            dp[cap][n] = dp[cap][n - 1];
          } else {
            dp[cap][n] = Math.max(dp[cap][n - 1], val[n - 1] + dp[cap - wt[n - 1]][n]);
          }
        }
      }
      return dp[CAP][N];
    }
  }
}
