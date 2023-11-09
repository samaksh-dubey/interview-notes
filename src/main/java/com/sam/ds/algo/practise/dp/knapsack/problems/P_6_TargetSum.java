package com.sam.ds.algo.practise.dp.knapsack.problems;

/**
 * Given:   Integer array = arr[]
 *          Target Sum = SUM
 * Problem: Assign + or - sign in front of elements such that sum of array becomes equal to target sum
 * <p>
 * Approach ==> Breakdown into two subset s.t. their diff is SUM
 * i.e. problem becomes same as Var_5_CountSubsetWithGivenDifference
 * */
public class P_6_TargetSum {
    static int targetSum(int[] arr, int targetSum) {
        return P_5_CountSubsetWithGivenDifference.countSubsetWithGivenDiff(arr, targetSum);
    }
}
