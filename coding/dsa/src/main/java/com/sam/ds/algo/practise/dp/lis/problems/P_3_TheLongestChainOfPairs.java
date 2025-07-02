package com.sam.ds.algo.practise.dp.lis.problems;

import java.util.Arrays;

public class P_3_TheLongestChainOfPairs {
    static class Pair {
        int a, b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        static Pair of(int a, int b) {
            return new Pair(a, b);
        }
    }

    static class Recursive {
        static int max;

        static int _msis(Pair [] A, int n) {
            if (n == 1)
                return 1;

            int max_here = 1;
            for (int i = 1; i < n; i++) {
                int msis_till_i_incl = _msis(A, i);
                if (A[n-1].a > A[i-1].b && msis_till_i_incl + 1 > max_here)
                    max_here = msis_till_i_incl + 1;
            }

            max = Math.max(max, max_here);

            return max_here;
        }

        static int msis(Pair[] A) {
            max = 1;
            _msis(A, A.length);
            return max;
        }
    }

    static class Memoize {
        static int _msis(Pair [] A, int n, int[] dp) {
            if (n == 1)
                return 1;

            if(dp[n-1] != -1)
                return dp[n-1];

            dp[n-1] = 1;
            for (int i = 1; i < n; i++) {
                int msis_till_i_incl = _msis(A, i, dp);
                if (A[n-1].a > A[i-1].b && msis_till_i_incl + 1 > dp[n-1])
                    dp[n-1] = msis_till_i_incl + 1;
            }

            return dp[n-1];
        }

        static int msis(Pair[] A) {
            if(A == null || A.length == 0)
                return 0;
            int[] dp = new int[A.length];
            Arrays.fill(dp, -1);
            _msis(A, A.length, dp);
            return Arrays.stream(dp).max().getAsInt();
        }
    }

    static class DP {
        static int msis(Pair [] A) {
            if(A == null || A.length == 0)
                return 0;
            int N = A.length;
            int[] dp = new int[N];

            for (int n = 1; n < N; n++) {
                dp[n-1] = 1;
                for (int i = 1; i < n; i++) {
                    int msis_till_i_incl = dp[i-1];
                    if (A[n-1].a > A[i-1].b && msis_till_i_incl + 1 > dp[n-1])
                        dp[n-1] = msis_till_i_incl + 1;
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

    public static void main(String[] args) {
//        System.out.println(Recursive.msis(new int[]{1, 101, 2, 3, 100, 4, 5}));
//        System.out.println(Memoize.msis(new int[]{1, 101, 2, 3, 100, 4, 5}));
//        System.out.println(DP.msis(new int[]{1, 101, 2, 3, 100, 4, 5}));
    }

}
