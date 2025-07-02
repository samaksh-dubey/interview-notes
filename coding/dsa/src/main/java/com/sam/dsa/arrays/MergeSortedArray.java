package com.sam.dsa.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] X, int[] Y) {
        int xlen = X.length, ylen = Y.length;
        int x = 0, y = 0;
        while (x + y < xlen && x < xlen && y < ylen) {
           if (X[x] < Y[y])
               x++;
           else
               y++;

        }
        if (y < xlen) {
            x = xlen - y;
        }
        for (int i = x, j = 0; i < xlen && j < y; i++, j++) {
            swap(X, Y, i, j);
        }
        Arrays.sort(X);
        Arrays.sort(Y);
        System.out.printf("");
    }

    public static void swap(int[] X, int[] Y, int x, int y) {
        int tempX = X[x], tempY = Y[y];
        X[x] = tempY;
        Y[y] = tempX;
    }

    public static void main(String[] args) {
        merge(new int[]{-7, -4, -1}, new int[]{-9, -8});
    }
}
