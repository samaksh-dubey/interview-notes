package com.sam.ds.algo.practise.arrays;

import java.util.*;

public class LongestSubArrayWithGivenSum {

    public static List<Integer> findMaxLenSubArray(List<Integer> nums, int target) {
        int n = nums.size(), sum = 0, len = 0, end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum+=nums.get(i);
            map.putIfAbsent(sum, i);
            if (map.containsKey(sum - target) && len < i - map.get(sum - target)) {
                len = i - map.get(sum - target);
                end = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = end - len + 1; i <= end; i++) {
            result.add(nums.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        findMaxLenSubArray(Arrays.asList(5, 6, -5, 5, 3, 5, 3, -2, 0), 8);
    }
}
