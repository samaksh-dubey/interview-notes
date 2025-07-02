package com.sam.dsa.dp.kadane.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_6_MaxSumExcludingMaxElement {
    static int maxSum(int[] A) {
        Set<Integer> positives = new HashSet<>();
        Arrays.stream(A).forEach(a -> {if (a > 0) positives.add(a);});
        final int INF = 1000000;
        int res = Integer.MIN_VALUE;

        for(int positive: positives) {

            int max_here = 0, max_so_far = -INF;
            for (int a: A) {
                int val = a > positive ? -INF : a;
                max_here = max_here + val;

                if (max_here < 0)
                    max_here = 0;

                if (max_here > max_so_far)
                    max_so_far = max_here;
            }

            if (max_so_far > res)
                res = max_so_far - positive;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {5, -2, 10, -1, 4}));
    }

}
