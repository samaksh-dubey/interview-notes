package com.sam.dsa.arrays;

public class ProductOfEveryOtherElement {

    public static void rearrange(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1], right = new int[n + 1];
        int leftProduct = 1, rightProduct = 1;
        for (int i = 0; i < n; i++) {
            left[i] = leftProduct;
            right[n - i] = rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];
        }
        for (int i = 0; i < n; i++)
            nums[i] = left[i] * right[i + 1];
    }

    public static void main(String[] args) {
        rearrange(new int[]{1, 2, 3, 4, 5});
        rearrange(new int[]{5, 3, 4, 2, 6, 8});
    }
}
