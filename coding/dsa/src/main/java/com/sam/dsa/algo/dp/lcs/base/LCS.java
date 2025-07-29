package com.sam.dsa.algo.dp.lcs.base;

public class LCS {
  static class Recursive {
    static int lcs(char[] A, char[] B, int a, int b) {
      if (a == 0 || b == 0) return 0;

      if (A[a] == B[b]) return 1 + lcs(A, B, a - 1, b - 1);

      return Math.max(lcs(A, B, a - 1, b), lcs(A, B, a, b - 1));
    }
  }

  static class Memoize {
    static int lcs(char[] A, char[] B, int a, int b, int[][] dp) {
      if (a == 0 || b == 0) return 0;

      if (dp[a][b] != -1) return dp[a][b];

      if (A[a] == B[b]) return dp[a][b] = 1 + lcs(A, B, a - 1, b - 1, dp);

      return dp[a][b] = Math.max(lcs(A, B, a - 1, b, dp), lcs(A, B, a, b - 1, dp));
    }
  }

  public static class DP {
    public static int lcs(char[] A, char[] B) {
      int A_LEN = A.length, B_LEN = B.length;

      int[][] dp = new int[A_LEN + 1][B_LEN + 1];

      for (int a = 0; a < A_LEN + 1; a++) {
        for (int b = 0; b < B_LEN + 1; b++) {
          if (a == 0 || b == 0) {
            dp[a][b] = 0;
          } else if (A[a] == B[b]) {
            dp[a][b] = 1 + dp[a - 1][b - 1];
          } else {
            dp[a][b] = Math.max(dp[a][b - 1], dp[a - 1][b]);
          }
        }
      }

      return dp[A_LEN][B_LEN];
    }
  }
}
