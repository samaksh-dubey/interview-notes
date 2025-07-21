package com.sam.dsa.arrays;

public class MaximumConsecutiveOnes {

  public static int findLongestSequence(int[] nums, int k) {
    if (nums == null || nums.length == 0) return -1;

    int i = 0, j, maxLen = 0, startIndex = 0, count = 0;

    for (j = 0; j < nums.length; j++) {
      if (nums[j] == 0) {
        count++;
      }

      while (count > k) {
        if (nums[i] == 0) count--;
        i++;
      }

      if (j - i + 1 > maxLen) {
        maxLen = j - i + 1;
        startIndex = i;
      }
    }
    return startIndex + maxLen - 1;
  }
}
