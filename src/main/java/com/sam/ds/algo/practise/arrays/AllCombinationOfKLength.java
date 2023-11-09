package com.sam.ds.algo.practise.arrays;

import java.util.*;

public class AllCombinationOfKLength {

    public static Set<List<Integer>> findCombinations(List<Integer> nums, int k) {
        if (nums == null || nums.isEmpty() || k == 0) {
            new HashSet<>();
        }
        Set<List<Integer>> subarrays = new HashSet<>();
        findCombinations(nums, 0, k, new ArrayList<>(), subarrays);
        return subarrays;
    }

    public static void findCombinations(List<Integer> nums, int i, int k, List<Integer> list, Set<List<Integer>> result) {
        if (i > nums.size())
            return;

        if (k > nums.size() - i)
            return;

        if (k == 0) {
            result.add(list);
            return;
        }

        List<Integer> including = new ArrayList<>(list);
        List<Integer> excluding = new ArrayList<>(list);
        including.add(nums.get(i));

        findCombinations(nums, i + 1, k - 1, including, result);
        findCombinations(nums, i + 1, k, excluding, result);
    }

    public static void main(String[] args) {
        findCombinations(Arrays.asList(1, 2, 3), 2);
    }
}
