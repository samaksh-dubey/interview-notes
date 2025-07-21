package com.sam.dsa.greedy;

import java.util.*;

public class MinCoins {

  static List<Integer> minCoin(Integer[] denominations, int val) {
    Arrays.sort(denominations, Collections.reverseOrder());
    List<Integer> coins = new ArrayList<>();
    for (int i = 0; i < denominations.length && val > 0; i++) {
      while (denominations[i] <= val) {
        coins.add(denominations[i]);
        val = val - denominations[i];
      }
    }
    return coins;
  }

  public static void main(String[] args) {
    int[] d = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    System.out.println(minCoin(Arrays.stream(d).boxed().toArray(Integer[]::new), 93));
  }
}
