package com.sam.dsa.ds._1_sorting.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.techiedelight.com/custom-sort-sort-elements-array-order-elements-defined-second-array/
// first = [5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4]
// order = [3, 5, 7, 2]
// Output: [3, 3, 3, 5, 5, 5, 7, 1, 1, 4, 4, 8, 8, 9, 9]
public class SortBasedOnOrder {

  public static void sort(Integer[] arr, Integer[] order) {
    Map<Integer, Integer> numberToIndex = new HashMap<>();

    for (int i = 0; i < order.length; i++) numberToIndex.put(order[i], i);

    Arrays.sort(
        arr,
        (n1, n2) -> {
          if (numberToIndex.containsKey(n1) && numberToIndex.containsKey(n2)) {
            return numberToIndex.get(n1) - numberToIndex.get(n2);
          } else if (numberToIndex.containsKey(n1)) {
            return -1;
          } else if (numberToIndex.containsKey(n2)) {
            return 1;
          } else {
            return Integer.compare(n1, n2);
          }
        });
  }
}
