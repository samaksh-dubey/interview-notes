package com.sam.dsa.dp.lcs.problems;

import com.sam.dsa.dp.lcs.base.LCS;

public class P_10_SequencePatternMatching {
  static boolean isSequencePattern(char[] A, char[] B) {
    int lcs = LCS.DP.lcs(A, B);
    return lcs == A.length;
  }
}
