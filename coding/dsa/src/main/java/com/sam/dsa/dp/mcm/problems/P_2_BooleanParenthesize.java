package com.sam.dsa.dp.mcm.problems;

public class P_2_BooleanParenthesize {

  static class DP {
    static int minParenthesis(char[] arr, char[] operator) {
      int N = arr.length;
      int[][] T = new int[N][N];
      int[][] F = new int[N][N];

      for (int i = 0; i < N; i++) {
        T[i][i] = arr[i] == 'T' ? 1 : 0;
        F[i][i] = arr[i] == 'F' ? 1 : 0;
      }

      for (int d = 1; d < N; d++) {
        for (int left = 0, right = left + d; right < N; left++, right++) {

          T[left][right] = F[left][right] = 0;
          for (int k = left; k < right; k++) {
            if (operator[k] == '&') {
              T[left][right] += T[left][k] * T[k + 1][right];
              F[left][right] +=
                  T[left][k] * F[k + 1][right]
                      + F[left][k] * T[k + 1][right]
                      + F[left][k] * F[k + 1][right];
            } else if (operator[k] == '|') {
              F[left][right] += F[left][k] * F[k + 1][right];
              T[left][right] +=
                  T[left][k] * F[k + 1][right]
                      + F[left][k] * T[k + 1][right]
                      + T[left][k] * T[k + 1][right];
            } else if (operator[k] == '^') {
              T[left][right] += F[left][k] * T[k + 1][right] + T[left][k] * F[k + 1][right];
              F[left][right] += T[left][k] * T[k + 1][right] + F[left][k] * F[k + 1][right];
            }
          }
        }
      }
      return T[0][N - 1];
    }
  }

  public static void main(String[] args) {
    char[] symbols = "TTFT".toCharArray();
    char[] operators = "|&^".toCharArray();
    int m = DP.minParenthesis(symbols, operators);
    System.out.println(m);
  }
}
