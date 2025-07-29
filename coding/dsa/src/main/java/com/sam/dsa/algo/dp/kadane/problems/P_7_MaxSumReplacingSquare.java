package com.sam.dsa.algo.dp.kadane.problems;

public class P_7_MaxSumReplacingSquare {
  static class Recursive {
    static int maxSum(int[] A, int n, int k) {
      if (n == 0) return Math.max(0, A[n]);

      int replacing = 0;
      if (k > 0) {
        replacing = Math.max(0, A[n] * A[n] + maxSum(A, n - 1, k - 1));
      }

      int not_replacing = Math.max(0, A[n] + maxSum(A, n - 1, k));
      return Math.max(replacing, not_replacing);
    }
  }

  static class Memoize {
    static int maxSum(int[] A, int n, int k, int[] dp) {
      if (n == 0) return dp[n] = Math.max(0, Math.max(A[n], A[n] * A[n]));

      if (dp[n] != -1) return dp[n];

      int replacing = 0;
      if (k > 0) {
        replacing = Math.max(0, A[n] * A[n] + maxSum(A, n - 1, k - 1, dp));
      }

      int not_replacing = Math.max(0, A[n] + maxSum(A, n - 1, k, dp));

      return Math.max(replacing, not_replacing);
    }
  }

  static class DP {
    static int maxSum(int[] A) {
      int N = A.length;
      int[][] dp = new int[N][2];

      for (int n = 0; n < N; n++) {
        for (int k = 0; k < 2; k++) {
          if (n == 0) {
            dp[n][k] = Math.max(0, Math.max(A[n], A[n] * A[n]));
          } else {
            int replacing = 0;
            if (k > 0) replacing = Math.max(0, A[n] * A[n] + dp[n - 1][k - 1]);

            int not_replacing = Math.max(0, A[n] + dp[n - 1][k]);
            dp[n][k] = Math.max(replacing, not_replacing);
          }
        }
      }
      int max = Integer.MIN_VALUE;
      for (int n = 0; n < N; n++) {
        for (int k = 0; k < 2; k++) {
          if (dp[n][k] > max) max = dp[n][k];
        }
      }
      return max;
    }
  }

  public static void main(String[] args) {
    System.out.println(DP.maxSum(new int[] {1, -5, 8, 12, -8}));
  }
}
