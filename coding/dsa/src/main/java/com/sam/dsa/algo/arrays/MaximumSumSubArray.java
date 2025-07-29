package com.sam.dsa.algo.arrays;

/** Kadane's Algorithm */
public class MaximumSumSubArray {

  public static int findMaxSubarraySum(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) if (max < num) max = num;

    if (max < 0) return max;

    int max_sum = 0, max_here = 0;

    for (int i = 0; i < nums.length; i++) {
      max_here += nums[i];
      max_here = Math.max(max_here, 0);
      max_sum = Math.max(max_sum, max_here);
    }
    return max_sum;
  }

  public static void main(String[] args) {
    findMaxSubarraySum(new int[] {5, 1, 0, -2, -1, -6, -5, -8, -7});
  }
}
