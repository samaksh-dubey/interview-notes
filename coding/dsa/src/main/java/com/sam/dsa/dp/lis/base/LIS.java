package com.sam.dsa.dp.lis.base;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LIS {

    static class Recursive {

        static int max = 1;

        static int _lis(int[] A, int n) {
            if (n == 1)
                return 1;

            int max_here = 1;

            for (int i = 1; i < n; i++) {
                int lis_till_i_incl = _lis(A, i);
                // ensure including n & then only include
                if (A[i-1] < A[n-1] && lis_till_i_incl + 1 > max_here)
                    max_here = lis_till_i_incl + 1;
            }

            if (max < max_here)
                max = max_here;

            // LIS till n & including n
            return max_here;
        }

        static int lis(int[] A) {
            if(A == null || A.length == 0)
                return 0;
            max = 1;
            _lis(A, A.length);
            return max;
        }
    }

    static class Memoize {

        static int _lis(int[] A, int n, int[] dp) {
            if (n == 1)
                return 1;

            if(dp[n-1] != -1)
                return dp[n-1];

            dp[n-1] = 1;
            for (int i = 1; i < n; i++) {
                int lis_till_i_incl = _lis(A, i, dp);
                if (A[i-1] < A[n-1] && lis_till_i_incl + 1 > dp[n-1])
                    dp[n-1] = lis_till_i_incl + 1;
            }

            return dp[n-1];
        }

        static int lis(int[] A) {
            if(A == null || A.length == 0)
                return 0;
            int[] dp = new int[A.length];
            Arrays.fill(dp, -1);
            _lis(A, A.length, dp);
            return Arrays.stream(dp).max().getAsInt();
        }
    }

    public static class DP {

        public static int lis(int[] A) {
            if(A == null || A.length == 0)
                return 0;
            int N = A.length;
            int[] dp = new int[N];

            for(int n = 1; n <= N; n++) {
                dp[n-1] = 1;
                for (int i = 1; i <= n; i++) {
                    int lis_till_i_incl = dp[i-1];
                    if (A[i-1] < A[n-1] && lis_till_i_incl + 1 > dp[n-1])
                        dp[n-1] = lis_till_i_incl + 1;
                }
            }
            return IntStream.of(dp).max().getAsInt();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 3, 4};
        System.out.println(Recursive.lis(arr));
        System.out.println(Memoize.lis(arr));
        System.out.println(DP.lis(arr));
    }
}
