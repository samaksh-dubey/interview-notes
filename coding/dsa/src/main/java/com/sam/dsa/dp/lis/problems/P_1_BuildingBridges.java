package com.sam.dsa.dp.lis.problems;

import com.sam.dsa.dp.lis.base.LIS;
import java.util.Arrays;

public class P_1_BuildingBridges {
  static class CityPairs implements Comparable<CityPairs> {
    int north, south;

    @Override
    public int compareTo(CityPairs o) {
      if (this.north == o.north) return this.south - o.south;
      return this.north - o.north;
    }
  }

  static int maxBridges(CityPairs[] pairs) {
    Arrays.sort(pairs);
    int[] south = Arrays.stream(pairs).mapToInt(a -> a.south).toArray();
    return LIS.DP.lis(south);
  }
}
