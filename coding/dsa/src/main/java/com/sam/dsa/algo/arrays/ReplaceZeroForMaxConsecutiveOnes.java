package com.sam.dsa.algo.arrays;

public class ReplaceZeroForMaxConsecutiveOnes {
  public static int findIndexofZero(int[] nums) {
    int index = -1, len = 0, n = nums.length;
    int i = 0, prev = -1, secondPrev = -1;
    while (i < n) {
      if (nums[i] == 0) {
        secondPrev = prev;
        prev = i;
      }
      if (len < i - secondPrev) {
        len = i - secondPrev;
        index = prev;
      }
      i++;
    }
    return index;
  }

  public static void main(String[] args) {
    findIndexofZero(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1});
  }
}
