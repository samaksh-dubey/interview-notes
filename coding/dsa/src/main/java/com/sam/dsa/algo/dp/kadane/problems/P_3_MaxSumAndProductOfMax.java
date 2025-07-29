package com.sam.dsa.algo.dp.kadane.problems;

public class P_3_MaxSumAndProductOfMax {

  static int kadane(int[] arr) {
    int max_sum_prod = 0, curr_max_num = 0, curr_max_sum = 0;
    for (int a : arr) {
      curr_max_sum = curr_max_sum + a;
      curr_max_num = Math.max(curr_max_num, a);
      max_sum_prod = Math.max(max_sum_prod, curr_max_sum);

      if (curr_max_sum <= 0) {
        curr_max_sum = 0;
        curr_max_num = 0;
      }
    }
    return max_sum_prod;
  }

  static int max(int[] arr, int n) {
    int largestSum = kadane(arr);

    for (int i = 0; i < n; i++) arr[i] = -arr[i];

    return Math.max(largestSum, kadane(arr));
  }
}
