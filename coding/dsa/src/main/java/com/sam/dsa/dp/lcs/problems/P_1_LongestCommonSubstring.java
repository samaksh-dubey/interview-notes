package com.sam.dsa.dp.lcs.problems;

import java.util.Arrays;

public class P_1_LongestCommonSubstring {

  static class Recursive {
    static int lcs(char[] A, char[] B, int a, int b, int count) {
      if (a == 0 || b == 0) return 0;

      if (A[a] == B[b]) count = 1 + lcs(A, B, a - 1, b - 1, count);

      count = Math.max(count, Math.max(lcs(A, B, a - 1, b, 0), lcs(A, B, a, b - 1, 0)));
      return count;
    }
  }

  static class Memoize {
    static int lcs(char[] A, char[] B, int a, int b, int[][] dp, int res) {
      if (a == 0 || b == 0) return 0;

      if (dp[a][b] != -1) return dp[a][b];

      int res_a = lcs(A, B, a - 1, b, dp, 0);
      int res_b = lcs(A, B, a, b - 1, dp, 0);
      if (A[a - 1] == B[b - 1]) {
        dp[a][b] = 1 + lcs(A, B, a - 1, b - 1, dp, res++);
      } else {
        dp[a][b] = 0;
      }
      return Math.max(Math.max(res_a, res_b), res);
    }
  }

  static class DP {
    static int lcs(char[] A, char[] B) {
      int A_LEN = A.length, B_LEN = B.length;

      int[][] dp = new int[A_LEN + 1][B_LEN + 1];

      int result = 0;

      for (int a = 0; a < A_LEN + 1; a++) {
        for (int b = 0; b < B_LEN + 1; b++) {
          if (a == 0 || b == 0) {
            dp[a][b] = 0;
          } else if (A[a - 1] == B[b - 1]) {
            dp[a][b] = 1 + dp[a - 1][b - 1];
            result = Math.max(dp[a][b], result);
          } else {
            dp[a][b] = 0;
          }
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    char[] A = "OldSite:GeeksforGeeks.org".toCharArray();
    char[] B = "NewSite:GeeksQuiz.com".toCharArray();
    int[][] dp = new int[A.length + 1][B.length + 1];
    Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
    int m = Memoize.lcs(A, B, A.length, B.length, dp, 0);
    System.out.println(m);
  }
}
