package com.sam.dsa.arrays;

public class RearrangeAllZeroAtEnd {

    public static void rearrange(int[] nums) {
        int n = nums.length, nonZero = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] != 0)
                nonZero++;

        int j = 0;
        for (int i = 0; i < n && j < nonZero; i++)
            if (nums[i] != 0)
                swap(nums, i, j++);

        for (int i = j; i < n; i++)
            nums[i] = 0;

        System.out.printf("");
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        rearrange(new int[]{6, 0, 8, 2, 3, 0, 4, 0, 1});
    }
}
