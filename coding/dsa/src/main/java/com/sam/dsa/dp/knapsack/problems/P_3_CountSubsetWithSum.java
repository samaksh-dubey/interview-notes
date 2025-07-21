package com.sam.dsa.dp.knapsack.problems;

public class P_3_CountSubsetWithSum {
  static class Recursive {
    static int countSubsetSum(final int[] arr, final int N, final int SUM) {
      if (SUM == 0) return 1;
      if (N == 0) return 0;
      if (arr[N - 1] > SUM) return countSubsetSum(arr, N - 1, SUM);
      return countSubsetSum(arr, N - 1, SUM) + countSubsetSum(arr, N - 1, SUM - arr[N - 1]);
    }
  }

  static class Memoize {
    static int countSubsetSum(final int[] arr, final int N, final int SUM, final int[][] dp) {
      if (SUM == 0) return 1;
      if (N == 0) return 0;

      if (dp[SUM][N] != -1) return dp[SUM][N];

      if (arr[N - 1] > SUM) return dp[SUM][N] = countSubsetSum(arr, N - 1, SUM, dp);
      return dp[SUM][N] =
          countSubsetSum(arr, N - 1, SUM, dp) + countSubsetSum(arr, N - 1, SUM - arr[N - 1], dp);
    }
  }

  static class DP {
    static int countSubsetSum(final int[] arr, final int N, final int SUM) {
      int[][] dp = new int[SUM + 1][N + 1];
      for (int s = 0; s < SUM + 1; s++) {
        for (int n = 0; n < N + 1; n++) {
          if (s == 0 && n == 0) dp[s][n] = 1;
          else if (s == 0) dp[s][n] = 1;
          else if (n == 0) dp[s][n] = 0;
          else if (arr[n - 1] <= s) dp[s][n] = dp[s][n - 1];
          else dp[s][n] = dp[s][n - 1] + dp[s - arr[n - 1]][n - 1];
        }
      }
      return dp[SUM][N];
    }
  }
}
