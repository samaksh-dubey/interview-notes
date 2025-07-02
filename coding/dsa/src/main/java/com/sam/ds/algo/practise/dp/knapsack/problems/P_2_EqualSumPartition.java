package com.sam.ds.algo.practise.dp.knapsack.problems;

import java.util.Arrays;

/**
 * Given:   Integer Array = arr[]
 * Problem: Does two subset exist s.t. both have equal sum
 * */
public class P_2_EqualSumPartition {

    static boolean equalSumPartition(int[] arr) {
        int N = arr.length, SUM = Arrays.stream(arr).sum();
        if (SUM % 2 != 0)
            return false;
        else
            return P_1_SubsetSum.DP.subsetSum(arr, N, SUM/2);
    }
}
