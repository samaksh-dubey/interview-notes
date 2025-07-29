package com.sam.dsa.ds._1_sorting.questions;

import java.util.Objects;

// https://www.techiedelight.com/positive-and-negative-integers-segregate/
// Multiple ways -> 1. use two pointers
//                  2. use quick sort partition logic
public class SegregateNegPosNumbers {

  public static void segregate(int[] nums) {
    if (Objects.isNull(nums) || nums.length == 0) {
      return;
    }

    partition(nums, 0, nums.length - 1);
  }

  private static void partition(int[] nums, int lo, int hi) {
    int pIndex = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] < 0) {
        swap(nums, i, pIndex++);
      }
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
