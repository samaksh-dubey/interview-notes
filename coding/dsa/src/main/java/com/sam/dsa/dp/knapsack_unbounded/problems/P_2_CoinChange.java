package com.sam.dsa.dp.knapsack_unbounded.problems;
/**
 * Given:   array of coins = coins[]
 *          total money needed = total
 * Problem: number of ways that change can be made
 * */
public class P_2_CoinChange {

    static class Recursive {
        static int coinChange(int[] coins, int total, int n) {
            if (n == 0)
                return 0;
            if (total == 0)
                return 1;
            if (total < coins[n])
                return coinChange(coins, total, n-1);
            return coinChange(coins, total - coins[n-1], n) + coinChange(coins, total, n-1);
        }
    }

    static class Memoize {
        static int coinChange(int[] coins, int total, int n) {
            if (n == 0)
                return 0;
            if (total == 0)
                return 1;
            if (total < coins[n])
                return coinChange(coins, total, n-1);
            return coinChange(coins, total - coins[n-1], n) + coinChange(coins, total, n-1);
        }
    }

    static class DP {
        static int coinChange(final int[] coins, final int TOTAL, final int N) {
            int[][] dp = new int[TOTAL+1][N+1];
            for(int t = 0; t < TOTAL + 1; t++) {
                for(int n = 0; n < N + 1; n++) {
                    if (n == 0 && t == 0)
                        dp[t][n] = 1;
                    else if (t == 0)
                        dp[t][n] = 1;
                    else if (n == 0)
                        dp[t][n] = 0;
                    else if (t < coins[n-1])
                        dp[t][n] = dp[t][n-1];
                    else
                        dp[t][n] = dp[t-coins[n-1]][n] + dp[t][n-1];
                }
            }
            return dp[TOTAL][N];
        }
    }
}
