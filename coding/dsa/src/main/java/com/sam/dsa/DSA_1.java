package com.sam.dsa;

public class DSA_1 {

  public static int maxWater(int[] arr) {
    if (arr == null || arr.length < 3) return 0;
    int sum = 0, N = arr.length;
    int[] L = new int[N], R = new int[N];

    L[0] = arr[0];
    for (int i = 1; i < N; i++) {
      L[i] = Math.max(L[i - 1], arr[i]);
    }

    R[N - 1] = arr[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      R[i] = Math.max(R[i + 1], arr[i]);
    }

    for (int i = 1; i < N - 1; i++) {
      sum = sum + Math.min(L[i], R[i]) - arr[i];
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(maxWater(new int[] {3, 0, 0, 2, 0, 4}));
    System.out.println(maxWater(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
