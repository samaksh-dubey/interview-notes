package com.sam.dsa.dp.lcs.problems;

import com.sam.dsa.dp.lcs.base.LCS;

public class P_7_MinimumDeletionToMakePalindrome {
    static int minDeletion(char[] A) {
        int lcs = LCS.DP.lcs(A, reverse(A));
        return A.length - lcs;
    }

    private static char[] reverse(char[] a) {
        char[] reverse = new char[a.length];
        for(int i = 0; i < a.length; i++)
            reverse[i] = a[a.length - i - 1];
        return reverse;
    }
}
