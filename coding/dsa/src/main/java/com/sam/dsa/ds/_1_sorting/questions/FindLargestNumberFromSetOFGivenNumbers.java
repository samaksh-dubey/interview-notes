package com.sam.dsa.ds._1_sorting.questions;

import java.util.List;
import java.util.stream.Collectors;

// https://www.techiedelight.com/find-largest-number-possible-set-given-numbers/
// Input:  { 10, 68, 75, 7, 21, 12 }
// Output: 77568211210
public class FindLargestNumberFromSetOFGivenNumbers {

  public static String largestNumber(List<Integer> numbers) {
    numbers.sort(
        (n1, n2) -> {
          String s1 = String.valueOf(n1), s2 = String.valueOf(n2);
          return -Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
        });

    return numbers.stream().map(String::valueOf).collect(Collectors.joining());
  }
}
