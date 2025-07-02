package com.sam.dsa.dp.knapsack.problems;

/**
 * Given: Positive integer's array = arr[] and sum = S
 * Problem: find a subset which has sum equal to the given sum
 * */
public class P_1_SubsetSum {

    static class Recursive {

        static boolean subsetSum(int[] arr, int n, int sum) {
            if (sum == 0)
                return true;

            if (n == 0)
                return false;

            if (arr[n-1] > sum)
                return subsetSum(arr, n - 1, sum);

            return subsetSum(arr, n - 1, sum - arr[n - 1]) || subsetSum(arr, n - 1, sum);
        }
    }

    static class Memoize {

        static Boolean subsetSum(int[] arr, int n, int sum, Boolean[][] dp) {
            if (sum == 0)
                return true;

            if (n == 0)
                return false;

            if (dp[n][sum] != null)
                return dp[n][sum];

            if (arr[n-1] > sum)
                return subsetSum(arr, n - 1, sum, dp);

            return dp[n][sum] = subsetSum(arr, n - 1, sum - arr[n - 1], dp) || subsetSum(arr, n - 1, sum, dp);
        }
    }

    static class DP {

        static Boolean subsetSum(int[] arr, int N, int sum) {
            Boolean[][] dp = new Boolean[sum + 1][N + 1];

            for (int s = 0; s < sum + 1; s++) {
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
            return dp[sum][N];
        }
    }
}
