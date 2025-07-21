package com.sam.dsa.dp.knapsack.base;

/** Given :: Items : wt[], val[], size = n Capacity = C Maximize Value taken in knapsack */
public class Knapsack_01 {
  private static class Recursive {
    static int knapsack(int[] wt, int[] val, int C, int n) {
      if (n == 0 || C == 0) return 0;

      if (wt[n - 1] < C)
        return Math.max(
            val[n - 1] + knapsack(wt, val, C - wt[n - 1], n - 1), knapsack(wt, val, C, n - 1));
      else return knapsack(wt, val, C, n - 1);
    }
  }

  // Initialize memo with -1 and memo = new int[C + 1][n + 1]
  private static class Memoize {
    static int knapsack(int[] wt, int[] val, int C, int n, int[][] dp) {
      if (n == 0 || C == 0) return 0;

      if (dp[C][n] != -1) return dp[C][n];

      if (wt[n - 1] > C) {
        return dp[C][n] = knapsack(wt, val, C, n - 1, dp);
      } else {
        return dp[C][n] =
            Math.max(
                val[n - 1] + knapsack(wt, val, C - wt[n - 1], n - 1, dp),
                knapsack(wt, val, C, n - 1, dp));
      }
    }
  }

  private static class DP {
    static int knapsack(int[] wt, int[] val, int C, int n) {
      int[][] dp = new int[n + 1][C + 1];
      for (int i = 0; i <= C; i++) {
        for (int j = 0; j <= n; j++) {
          if (i == 0 || j == 0) {
            dp[i][j] = 0;
          } else if (wt[j - 1] > i) {
            dp[i][j] = dp[i][j - 1];
          } else {
            dp[i][j] = Math.max(dp[i - wt[j - 1]][j - 1] + val[j - 1], dp[i][j - 1]);
          }
        }
      }
      return dp[C][n];
    }
  }
}
