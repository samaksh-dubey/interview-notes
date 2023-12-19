package com.sam.ds.algo.practise.dp.mcm.problems;

import java.util.Arrays;
import java.util.Map;

public class P_1_PalindromePartitioning {

    static class Recursive {
        static int partition(char[] A, int left, int right) {
            if (left >= right)
                return 0;

            if (isPalindrome(A, left, right))
                return 0;

            int min = Integer.MAX_VALUE;
            for(int k = left; k <= right; k++) {
                int temp = 1 + partition(A, left, k) + partition(A, k + 1, right);
                min = Math.min(min, temp);
            }
            return min;
        }

        private static boolean isPalindrome(char[] A, int l, int r) {
            if (l == r)
                return true;

            if(l + 1 == r && A[l] == A[r])
                return true;

            if(A[l] == A[r])
                return isPalindrome(A, ++l, --r);
            return false;
        }
    }

    static class Memoize {
        static int partition(char[] A, int left, int right, Boolean[][] palindromeDP, int[][] dp) {
            if (left >= right)
                return 0;

            if (dp[left][right] != -1) {
                return dp[left][right];
            }

            if (isPalindrome(A, left, right, palindromeDP))
                return dp[left][right] = 0;

            int min = Integer.MAX_VALUE;
            for(int k = left; k < right; k++) {
                int temp = 1 + partition(A, left, k, palindromeDP, dp) + partition(A, k + 1, right, palindromeDP, dp);
                min = Math.min(min, temp);
            }
            return dp[left][right] = min;
        }

        private static boolean isPalindrome(char[] A, int l, int r, Boolean[][] dp) {
            if (dp[l][r] != null)
                return dp[l][r];

            if (l == r || (l + 1 == r && A[l] == A[r]))
                return dp[l][r] = true;

            if(A[l] == A[r])
                return dp[l][r] = isPalindrome(A, ++l, --r, dp);
            return dp[l][r] = false;
        }
    }

    static class DP {
        static int partition(char[] A) {
            int N = A.length;
            int[][] dp = new int[N][N];
            Boolean[][] palindromeDP = new Boolean[N][N];

            isPalindrome(A, N, palindromeDP);
            for(int d = 1; d < N; d++) {
                for (int left = 0, right = left + d; right < N; left++, right++) {

                    if (palindromeDP[left][right]) {
                        dp[left][right] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for(int k = left; k < right; k++) {
                            int temp = 1 + dp[left][k] + dp[k+1][right];
                            min = Math.min(min, temp);
                        }
                        dp[left][right] = min;
                    }
                }
            }
            return dp[0][N-1];
        }

        private static void isPalindrome(char[] A, int N, Boolean[][] dp) {
            for(int i = 0; i < N; i ++)
                dp[i][i] = true;

            for(int d = 1; d < N; d++) {
                for(int left = 0, right = left + d; right < N; left++, right++) {

                    if ((left + 1 == right && A[left] == A[right]))
                        dp[left][right] = true;
                    else if (A[left] == A[right])
                        dp[left][right] = dp[left+1][right-1];
                    else
                        dp[left][right] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] A = "ababbbabbababa".toCharArray();
        int[][] dp = new int[A.length][A.length];
        Boolean[][] palindromeDP = new Boolean[A.length][A.length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        Arrays.stream(palindromeDP).forEach(a -> Arrays.fill(a, null));
        int m = Memoize.partition(A, 0 , A.length - 1, palindromeDP, dp);
        int n = DP.partition(A);
        System.out.println(m);
        System.out.println(n);
    }
}
