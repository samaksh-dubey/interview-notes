package com.sam.dsa.dp.kadane.problems;

import java.util.Arrays;

public class P_9_MaxSumSubArrayRemovingKElements {

    static class Recursive {
        static int maxSumSubArray(int[] arr, int n, int k) {
            if (n == 0)
                return 0;

            int including = Math.max(0, arr[n-1] + maxSumSubArray(arr, n - 1, k));
            if (k == 0)
                return including;
            int excluding = maxSumSubArray(arr, n - 1, k - 1);
            return Math.max(including, excluding);
        }
    }

    static class Memoize {
        static int maxSumSubArray(int[] arr, int n, int k, int[][] dp) {
            if (n == 0)
                return dp[n][k] = Math.max(0, arr[n]);

            if (dp[n][k] != -1)
                return dp[n][k];

            int including = Math.max(0, arr[n] + maxSumSubArray(arr, n - 1, k, dp));

            if (k == 0)
                return dp[n][k] = including;

            int excluding = maxSumSubArray(arr, n - 1, k - 1, dp);
            return dp[n][k] = Math.max(including, excluding);
        }
    }

    static class DP {
        static int maxSumSubArray(int[] arr, int K) {
            if(arr == null || arr.length == 0)
                return 0;

            int N = arr.length;
            int[][] dp = new int[N][K + 1];

            for (int n = 0; n < N; n++) {
                for(int k = 0; k < K + 1; k++) {
                    if(n == 0)
                        dp[n][k] = Math.max(0, arr[0]);
                    else {
                        int including = Math.max(0, arr[n] + dp[n-1][k]);
                        if (k == 0) {
                            dp[n][k] = including;
                        } else {
                            int excluding = dp[n-1][k-1];
                            dp[n][k] = Math.max(including, excluding);
                        }
                    }
                }
            }
            int max = 0;
            for (int n = 0; n < N; n++) {
                for (int k = 0; k < K + 1; k++) {
                    max = Math.max(max, dp[n][k]);
                }
            }

            if(Arrays.stream(arr).max().getAsInt() < 0)
                max = Arrays.stream(arr).max().getAsInt();

            return max;
        }
    }
}
