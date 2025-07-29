package com.sam.dsa.algo.dp.lcs.problems;

public class P_9_LongestRepeatingSubsequence {
  static class Recursive {
    static int lrs(char[] A, int a, int b) {
      if (a == 0 || b == 0) return 0;

      if (A[a - 1] == A[b - 1] && a != b) return 1 + lrs(A, a - 1, b - 1);
      return Math.max(lrs(A, a - 1, b), lrs(A, a, b - 1));
    }
  }

  static class Memoize {
    static int lrs(char[] A, int a, int b, int dp[][]) {
      if (a == 0 || b == 0) return 0;

      if (dp[a][b] != -1) return dp[a][b];

      if (A[a - 1] == A[b - 1] && a != b) return dp[a][b] = 1 + lrs(A, a - 1, b - 1, dp);
      return dp[a][b] = Math.max(lrs(A, a - 1, b, dp), lrs(A, a, b - 1, dp));
    }
  }

  static class DP {
    static int lcs(char[] A) {
      int A_LEN = A.length;

      int[][] dp = new int[A_LEN + 1][A_LEN + 1];

      for (int a = 0; a < A_LEN + 1; a++) {
        for (int b = 0; b < A_LEN + 1; b++) {
          if (a == 0 || b == 0) {
            dp[a][b] = 0;
          } else if (A[a] == A[b] && a != b) {
            dp[a][b] = 1 + dp[a - 1][b - 1];
          } else {
            dp[a][b] = Math.max(dp[a][b - 1], dp[a - 1][b]);
          }
        }
      }

      return dp[A_LEN][A_LEN];
    }
  }
}
