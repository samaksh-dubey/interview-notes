package com.sam.dsa.algo.dp.lcs.problems;

import com.sam.dsa.algo.dp.lcs.base.LCS;

public class P_6_LongestPalindromicSubsequence {
  static class Recursive {
    static int lps(char[] A, int l, int r) {
      if (l == r) return 1;

      if (l + 1 == r && A[l] == A[r]) return 2;

      if (A[l] == A[r]) return 2 + lps(A, l + 1, r - 1);
      else return Math.max(lps(A, l, r - 1), lps(A, l + 1, r));
    }
  }

  static class Memoize {
    static int lps(char[] A, int l, int r, int[][] dp) {
      if (l == r) return dp[l][r] = 1;

      if (l + 1 == r && A[l] == A[r]) return dp[l][r] = 2;

      if (dp[l][r] != -1) return dp[l][r];

      if (A[l] == A[r]) return dp[l][r] = 2 + lps(A, l + 1, r - 1, dp);
      else return dp[l][r] = Math.max(lps(A, l, r - 1, dp), lps(A, l + 1, r, dp));
    }
  }

  static class DP {
    static int longestPalindromicSubsequence(char[] A) {
      char[] B = reverse(A);
      return LCS.DP.lcs(A, B);
    }

    private static char[] reverse(char[] a) {
      char[] reverse = new char[a.length];
      for (int i = 0; i < a.length; i++) reverse[i] = a[a.length - i - 1];
      return reverse;
    }
  }
}
