package com.sam.dsa.dp.mcm.problems;

public class P_4_EggDroppingProblem {

    static class Recursive {
        static int min(int eggs, int floors) {
            if (floors == 0 || floors == 1)
                return floors;

            if(eggs == 1)
                return floors;

            int res = floors;
            for(int k = 1; k <= floors; k++) {
                int temp = 1 + Math.max(min(eggs - 1, k - 1), min(eggs, floors - k));
                res = Math.min(res, temp);
            }
            return res;
        }
    }

    static class Memoize {
        static int min(int eggs, int floors, int[][] dp) {
            if (floors == 0 || floors == 1)
                return dp[eggs][floors] = floors;

            if(eggs == 1)
                return dp[eggs][floors] = floors;

            if (dp[eggs][floors] != -1)
                return dp[eggs][floors];

            dp[eggs][floors] = floors;
            for(int k = 1; k <= floors; k++) {
                int temp = 1 + Math.max(min(eggs - 1, k - 1, dp), min(eggs, floors - k, dp));
                dp[eggs][floors] = Math.min(dp[eggs][floors], temp);
            }
            return dp[eggs][floors];
        }
    }

    static class DP {
        static int min(int EGGS, int FLOORS) {

            int[][] dp = new int[EGGS + 1][FLOORS + 1];

            for (int e = 0; e < EGGS + 1; e++) {
                for(int f = 0; f < FLOORS + 1; f++) {
                    if (f == 0 || f == 1)
                        dp[e][f] = f;
                    if (e == 1)
                        dp[e][f] = f;
                }
            }

            for (int e = 2; e < EGGS + 1; e++) {
                for (int f = 2; f < FLOORS + 1; f++) {
                    dp[e][f] = f;
                    for(int k = 1; k <= f; k++) {
                        int temp = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
                        dp[e][f] = Math.min(dp[e][f], temp);
                    }
                }
            }

            return dp[EGGS][FLOORS];
        }
    }
}
