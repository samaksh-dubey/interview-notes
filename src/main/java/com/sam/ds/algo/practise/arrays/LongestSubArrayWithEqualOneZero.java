package com.sam.ds.algo.practise.arrays;

import java.util.*;

public class LongestSubArrayWithEqualOneZero {

    public static List<Integer> findLargestSubarray(List<Integer> nums)
    {
        List<Integer> largestSubarray = new ArrayList<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 0)
                nums.set(i, -1);
        }
        int sum = 0, len = 0, end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum+=nums.get(i);
            if (map.containsKey(sum) && len < i - map.get(sum)) {
                len = i - map.get(sum);
                end = i;
            }
            map.putIfAbsent(sum, i);
        }
        for (int i = 0; i < n; i++) {
            if (nums.get(i) <= 0)
                nums.set(i, 0);
            if (i >= end - len + 1 && i <= end)
                largestSubarray.add(nums.get(i));
        }
        return largestSubarray;
    }

    public static void main(String[] args) {
        findLargestSubarray(Arrays.asList(1, 1, 0));
    }
}
