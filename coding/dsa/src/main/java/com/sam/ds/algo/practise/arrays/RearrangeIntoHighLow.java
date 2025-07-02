package com.sam.ds.algo.practise.arrays;

import java.util.List;

public class RearrangeIntoHighLow {
    public static void rearrange(List<Integer> A) {
        for (int i = 1; i < A.size(); i += 2) {
            if (A.get(i - 1) > A.get(i)) {
                swap(A, i - 1, i);
            }

            if (i + 1 < A.size() && A.get(i + 1) > A.get(i)) {
                swap(A, i + 1, i);
            }
        }
    }

    public static void swap(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
