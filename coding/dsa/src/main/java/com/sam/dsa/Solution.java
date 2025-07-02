package com.sam.dsa;

public class Solution {
    public static int maxPalindromes(String s, int K) {
        int N = s.length();
        char[] A = s.toCharArray();

        int[][] PARTITION_TABLE = new int[N][N];
        boolean[][] PALINDROME_TABLE = new boolean[N][N];

        fillPalindrome(A, N, PALINDROME_TABLE);

        for (int d = K - 1; d < N; d++) {
            for (int left = 0, right = left + d; right < N; left++, right++ ) {
                if (d == K - 1) {
                    PARTITION_TABLE[left][right] = PALINDROME_TABLE[left][right] ? 1 : 0;
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int k = left; k < right; k++) {
                        int temp = PARTITION_TABLE[left][k] + PARTITION_TABLE[k + 1][right];
                        max = Math.max(max, temp);
                    }
                    PARTITION_TABLE[left][right] = max;
                }
            }
        }

        return PARTITION_TABLE[0][N-1];
    }

    static void fillPalindrome(char[] A, int N, boolean[][] T) {
        for(int i = 0; i < N; i ++)
            T[i][i] = true;

        for (int i = 1; i < N; i++)
            if (A[i-1] == A[i])
                T[i-1][i] = true;

        for(int d = 2; d < N; d++) {
            for(int left = 0, right = left + d; right < N; left++, right++) {
                if (A[left] == A[right])
                    T[left][right] = T[left+1][right-1];
                else
                    T[left][right] = false;
            }
        }
    }

    public static void main(String[] args) {
        maxPalindromes("abaccdbbd", 3);
    }
}