package com.sam.ds.algo.practise.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquillibriumIndex {

    public static Set<Integer> findEquilibriumIndex(List<Integer> nums) {
        Set<Integer> indices = new HashSet<>();
        if (nums == null || nums.isEmpty())
            return indices;
        int sumRight = 0, n = nums.size(), sumLeft = 0;
        for (int i = 1; i < n; i++)
            sumRight+=nums.get(i);
        if (sumRight == 0)
            indices.add(0);
        for (int i = 1; i < n; i++) {
            sumLeft += nums.get(i-1);
            sumRight -= nums.get(i);
            if (sumLeft == sumRight)
                indices.add(i);
        }
        return indices;
    }

    public static void main(String[] args) {
        findEquilibriumIndex(Arrays.asList(1, 2, -3, 2));
    }
}
