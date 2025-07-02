package com.sam.dsa.dp.lcs.problems;

import com.sam.dsa.dp.lcs.base.LCS;

public class P_5_MinimumInsertionAndDeletion {
    static int findMinInsDel(char[] A, char[] B) {
        int a = A.length, b = B.length;
        int lcs = LCS.DP.lcs(A, B);
        int del = a - lcs, ins = b - lcs;
        return ins + del;
    }
}
