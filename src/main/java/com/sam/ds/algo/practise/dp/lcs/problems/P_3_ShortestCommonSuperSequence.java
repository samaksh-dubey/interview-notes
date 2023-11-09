package com.sam.ds.algo.practise.dp.lcs.problems;

import com.sam.ds.algo.practise.dp.lcs.base.LCS;

public class P_3_ShortestCommonSuperSequence {
    static int scs(char[] A, char[] B) {
        int a = A.length, b = B.length;
        int lcs = LCS.DP.lcs(A, B);
        return a + b - lcs;
    }
}
