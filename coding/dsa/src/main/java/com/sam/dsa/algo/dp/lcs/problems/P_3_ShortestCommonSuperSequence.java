package com.sam.dsa.algo.dp.lcs.problems;

import com.sam.dsa.algo.dp.lcs.base.LCS;

public class P_3_ShortestCommonSuperSequence {
  static int scs(char[] A, char[] B) {
    int a = A.length, b = B.length;
    int lcs = LCS.DP.lcs(A, B);
    return a + b - lcs;
  }
}
