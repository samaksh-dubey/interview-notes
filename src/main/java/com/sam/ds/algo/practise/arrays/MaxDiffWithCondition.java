package com.sam.ds.algo.practise.arrays;

public class MaxDiffWithCondition {

    public static int findMaxDiff(int[] arr) {
        int n = arr.length, maxDiff = -1, minHere = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= minHere)
                minHere = arr[i];
            else if (maxDiff < arr[i] - minHere)
                maxDiff = arr[i] - minHere;
        }
        return maxDiff;
    }

}
