package com.sam.dsa.dp.kadane.base;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Kadane {

    static class Recursive {
        static int maxSumSubArray(int[] A, int n) {
            if (n == 0)
                return Math.max(0, A[n]);
            return Math.max(0, A[n] + maxSumSubArray(A, n -1));
        }
    }

    static class Memoize {
        static int maxSumSubArray(int[] A, int n, int[] dp) {
            if (n == 0)
                return dp[n] = Math.max(0, A[n]);

            if (dp[n] != -1)
                return dp[n];

            return dp[n] = Math.max(0, A[n] + maxSumSubArray(A, n -1, dp));
        }
    }

    public static class DP {
        public static int maxSumSubArray(int[] A) {
            if(A == null || A.length == 0)
                return 0;

            int N = A.length;
            int[] dp = new int[N];
            for (int n = 0; n < N; n++) {
                if (n == 0)
                    dp[n] = Math.max(0, A[n]);
                else {
                    dp[n] = Math.max(0, A[n] + dp[n-1]);
                }
            }
            int max = IntStream.of(dp).max().getAsInt();
            if (Arrays.stream(A).max().getAsInt() < 0)
                max = Arrays.stream(A).max().getAsInt();
            return max;
        }
    }

    static int maxSumSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int max_ending_here = 0, max = Integer.MIN_VALUE;
        for (int a: A) {
            max_ending_here += a;
            max_ending_here = Math.max(max_ending_here, a);
            max = Math.max(max_ending_here, max);
        }
        return max;
    }

    static int[] getMaxSumSubArray(int[] A) {
        if (A == null || A.length == 0)
            return new int[0];

        int max_ending_here = 0, max = Integer.MIN_VALUE, end = 0, start = 0, start_here = 0;

        for (int i = 0; i < A.length; i++) {
            max_ending_here += A[i];

            if (max_ending_here < A[i]) {
                max_ending_here = A[i];
                start_here = i;
            }

            if (max_ending_here > max) {
                max = max_ending_here;
                end = i;
                start = start_here;
            }
        }

        return Arrays.copyOfRange(A, start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[] {-8, -3, -6, -2, -5, -4}));
        System.out.println(Arrays.toString(getMaxSumSubArray(new int[] {-8, -3, -6, -2, -5, -4})));

        System.out.println(maxSumSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(Arrays.toString(getMaxSumSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, -10, 4, 2})));

    }
}
