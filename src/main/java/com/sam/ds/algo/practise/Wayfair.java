package com.sam.ds.algo.practise;

import java.util.Arrays;
import java.util.List;

/**
 * Longest Consecutive Zeros Sub array less than size K
 * */
public class Wayfair {

    public static int max(List<Integer> encrypted, List<Integer> binary, int k) {
        int oneSum = 0, zeroSum = 0, max = 0, count = 0, beg = -1;

        for (int i = 0; i < encrypted.size(); i++) {
            if (binary.get(i) == 1) {
                oneSum = oneSum + encrypted.get(i);
                zeroSum = 0;
                count = 0;
                beg = i + 1;
            }

            if (binary.get(i) == 0) {
                zeroSum = zeroSum + encrypted.get(i);
                count++;
                if (count > k) {
                    zeroSum = zeroSum - encrypted.get(beg++);
                    count--;
                }
                max = Math.max(max, zeroSum);
            }
        }

        return oneSum + max;
    }

    public static void main(String[] args) {
        System.out.println(max(Arrays.asList(7,4,3,5,2), Arrays.asList(1, 0, 0, 0, 0), 2));
    }
}
