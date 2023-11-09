package com.sam.ds.algo.practise.dp.knapsack_unbounded.problems;

import java.util.Arrays;

/**
 * Given:   Length of rod = int L
 *          Length array = length[] ==> if not given then assume from 1 to N
 *          Price array = price[]
 * Problem:
 * */
public class P_1_RodCutting {
    static class Recursive {
        static int maxProfit(int[] price, int L, int n) {
            if (L == 0)
                return 0;
            if (n == 0)
                return 0;
            if (n > L)
                return maxProfit(price, L, n-1);
            return Math.max(maxProfit(price, L, n-1),
                    price[n-1] + maxProfit(price, L - n, n));
        }
    }

    static class Memoize {
        static int maxProfit(int[] price, int l, int n, int[][] dp) {
            if (l == 0)
                return 0;
            if (n == 0)
                return 0;
            if (dp[n][l] != -1) {
                return dp[n][l];
            }
            if (n > l)
                return dp[n][l] = maxProfit(price, l, n-1, dp);
            return dp[n][l] = Math.max(maxProfit(price, l, n-1, dp),
                    price[n-1] + maxProfit(price, l - n, n, dp));
        }
    }

    static class DP {
        static int maxProfit(int[] price, int L) {
            int N = price.length;
            int[][] dp = new int[L+1][N+1];
            Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

            for(int l = 0; l < L + 1; l++) {
                for(int n = 0; n < N + 1; n++) {
                    if (n == 0 || l == 0) {
                        dp[l][n] = 0;
                    } else if (n > l) {
                        dp[l][n] = dp[l][n-1];
                    } else {
                        dp[l][n] = Math.max(dp[l][n-1], price[n-1] + dp[l-n][n]);
                    }
                }
            }

            return dp[L][N];
        }
    }

    public static void main(String[] args) {
        int m = DP.maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 4);
        System.out.println(m);
    }
}
