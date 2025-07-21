package com.sam.dsa.dp.mcm.base;

/**
 * Given: Either a String or Array Has to be broken in range i to k & k + 1 to j where i < k < j
 * After breaking, the answers have to be merged/compared etc
 */
import java.util.Arrays;

/**
 * Given: Integer array = arr[] each element represent size of a matrix Problem: Calculate
 * M1*M2*M3....Mn s.t. Cost of Multiplication is minimum i.e. no of multiplications are minimum
 */
public class MCM {

  static class Recursive {
    static int minCost(int[] arr, int l, int r) {
      if (l >= r) return 0;

      int min = Integer.MAX_VALUE;
      for (int k = l; k < r; k++) {
        int temp = arr[l - 1] * arr[k] * arr[r] + minCost(arr, l, k) + minCost(arr, k + 1, r);
        min = Math.min(min, temp);
      }
      return min;
    }
  }

  static class Memoize {
    static int minCost(int[] arr, int l, int r, int[][] dp) {
      if (l >= r) return 0;

      if (dp[l][r] != -1) return dp[l][r];

      dp[l][r] = Integer.MAX_VALUE;
      for (int k = l; k < r; k++) {
        int temp =
            arr[l - 1] * arr[k] * arr[r] + minCost(arr, l, k, dp) + minCost(arr, k + 1, r, dp);
        dp[l][r] = Math.min(dp[l][r], temp);
      }
      return dp[l][r];
    }
  }

  static class DP {
    static int minCost(int[] arr) {
      int N = arr.length;
      int[][] dp = new int[N][N];

      for (int i = 0; i < N; i++) dp[i][i] = 0;

      for (int d = 1; d < N; d++) {
        for (int left = 1, right = left + d; right < N; left++, right++) {

          dp[left][right] = Integer.MAX_VALUE;
          for (int k = left; k < right; k++) {
            int temp = arr[left - 1] * arr[k] * arr[right] + dp[left][k] + dp[k + 1][right];
            dp[left][right] = Math.min(dp[left][right], temp);
          }
        }
      }
      return dp[1][N - 1];
    }
  }

  public static void main(String[] args) {
    int[][] dp = new int[4][4];
    Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
    int m = Recursive.minCost(new int[] {1, 2, 3, 4}, 1, 3);
    int n = MCM.Memoize.minCost(new int[] {1, 2, 3, 4}, 1, 3, dp);
    int o = MCM.DP.minCost(new int[] {1, 2, 3, 4});
    System.out.println(m);
    System.out.println(n);
    System.out.println(o);
  }
}
