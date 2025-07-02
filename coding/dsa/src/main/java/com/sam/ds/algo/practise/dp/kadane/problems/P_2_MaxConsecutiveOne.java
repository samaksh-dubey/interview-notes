package com.sam.ds.algo.practise.dp.kadane.problems;

public class P_2_MaxConsecutiveOne {
    static int maxConsecutiveOne(int[] A) {
        int max = 0, sum = 0;
        for (int a: A) {
            sum = sum + a;
            if(a == 0)
                sum = 0;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
