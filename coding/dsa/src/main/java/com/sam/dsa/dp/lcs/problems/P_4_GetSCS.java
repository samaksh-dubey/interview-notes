package com.sam.dsa.dp.lcs.problems;

public class P_4_GetSCS {

    static char[] getSCS(char[] A, char[] B) {
        int A_LEN = A.length, B_LEN = B.length;
        int[][] dp = new int[A_LEN + 1][B_LEN + 1];

        for (int a = 0; a < A_LEN + 1; a++) {
            for(int b = 0; b < B_LEN + 1; b++) {
                if (a == 0 || b == 0)
                    dp[a][b] = 0;
                else if (A[a-1] == B[b-1])
                    dp[a][b] = 1 + dp[a-1][b-1];
                else
                    dp[a][b] = Math.max(dp[a][b-1], dp[a-1][b]);
            }
        }

        int SCS_LEN = A_LEN + B_LEN - dp[A_LEN][B_LEN], a = A_LEN, b = B_LEN;
        char[] SCS = new char[SCS_LEN];

        while(a > 0 && b > 0) {
            if (A[a-1] == B[b-1]) {
                SCS[--SCS_LEN] = A[--a];
                b--;
            } else if (dp[a-1][b] > dp[a][b-1]) {
                SCS[--SCS_LEN] = A[--a];
            } else {
                SCS[--SCS_LEN] = B[--b];
            }
        }

        while(a > 0) {
            SCS[--SCS_LEN] = A[--a];
        }

        while(b > 0) {
            SCS[SCS_LEN--] = B[--b];
        }
        return SCS;
    }

}
