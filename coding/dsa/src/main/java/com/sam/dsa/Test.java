package com.sam.dsa;

import java.util.HashMap;
import java.util.Map;

/*
* Check if the given integer array is balanced or not.

Input is an array with +ve and -ve numbers. 

For every positive number there should be a corresponding matching negative number. 

Zeroes can be ignored. 

There can be duplicate numbers in the array.


Examples:

 
Balanced Array :- {1, 0, -3, 0,-1, 3, 0}

Balanced Array :- {5, 0, 1,-1, 3, -5, -3, 0}

Not Balanced Array :- {1,-1, 3, 7, 0, -7} Explanation : -3 is missing

Not Balanced Array :- {1, 2, -3}

Not Balanced Array :- {1, 1, -1}

Balanced Array :- {1, 1, -1, -1}
* */
public class Test {
    int[] a = new int[] {-1, -2, -3, 6};

    static boolean isBalanced(int[] arr) {
        if (arr == null)
            return false;
        if (arr.length == 0)
            return true;
        int n = arr.length;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] > 0) {
                cache.putIfAbsent(arr[i], 0);
                cache.put(arr[i], cache.get(arr[i]) + 1);
            } else {
                cache.putIfAbsent(-arr[i], 0);
                cache.put(-arr[i], cache.get(-arr[i]) - 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: cache.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(new int[]{1, 0, -3, 0,-1, 3, 0}));
        System.out.println(isBalanced(new int[]{5, 0, 1,-1, 3, -5, -3, 0}));
        System.out.println(isBalanced(new int[]{1,-1, 3, 7, 0, -7}));
        System.out.println(isBalanced(new int[]{1, 2, -3}));
        System.out.println(isBalanced(new int[]{1, 1, -1}));
        System.out.println(isBalanced(new int[]{1, 1, -1, -1}));
    }
}
