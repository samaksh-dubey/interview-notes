package com.sam.ds.algo.practise.dp.knapsack.problems;

import java.util.Arrays;

/**
 * Given:   Integer array = arr[]
 * Problem: Partition into two subset s.t. difference in their sum is minimum
 * */
public class P_4_MinimumSubsetSumDifference {
    static class DP {
        static int minSubsetSum(final int[] arr, final int N) {
            final int SUM = Arrays.stream(arr).sum();
            Boolean[][] dp = new Boolean[SUM + 1][N + 1];

            for (int s = 0; s < SUM + 1; s++) {
                for (int n = 0; n < N + 1; n++) {
                    if (s == 0 && n == 0 ) {
                        dp[s][n] = true;
                    } else if (s == 0) {
                        dp[s][n] = true;
                    } else if (n == 0) {
                        dp[s][n] = false;
                    } else if (arr[n - 1] <= s) {
                        dp[s][n] = dp[s - arr[n - 1]][n - 1] || dp[s][n - 1];
                    } else {
                        dp[s][n] = dp[s][n - 1];
                    }
                }
            }
            int minDiff = SUM;
            for (int s = 0; s < SUM + 1; s++) {
                if (dp[s][N])
                    minDiff = Math.min(minDiff, Math.abs(2 * s - SUM));
            }
            return minDiff;
        }
    }
}
