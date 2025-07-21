package com.sam.dsa;

import java.util.ArrayList;

public class Itr {

  static class Flatten2D {

    private final ArrayList<ArrayList<Integer>> lists;
    private int i, j;

    public Flatten2D(ArrayList<ArrayList<Integer>> arr2d) {
      // Write your code here.
      this.lists = arr2d;
      i = -1;
      j = -1;
    }

    public int next() {
      // Write your code here.
      if (i == -1 && j == -1) {
        i = 0;
        while (i < lists.size() && lists.get(i).isEmpty()) i++;

        j++;
      } else if (i < lists.size() && j + 1 < lists.get(i).size()) {
        j++;
      } else {
        j = -1;

        i++;
        while (lists.get(i).size() == 0) i++;

        j++;
      }
      return lists.get(i).get(j);
    }

    public boolean hasNext() {
      // Write your code here.
      int i_temp = i, j_temp = j;
      if (i_temp == -1 && j_temp == -1) {
        i_temp = 0;
        while (i_temp < lists.size() && lists.get(i_temp).size() == 0) i_temp++;
        j_temp++;
      } else if (j_temp + 1 < lists.get(i_temp).size()) {
        j_temp++;
      } else {
        j_temp = -1;

        i_temp++;
        while (i_temp < lists.size() && lists.get(i_temp).size() == 0) i_temp++;

        j_temp++;
      }
      return i_temp < lists.size() && j_temp < lists.get(i_temp).size();
    }
  }

  public static void main(String[] args) {
    //        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    //        lists.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
    //        lists.add(new ArrayList<>(Arrays.asList(-5)));
    //
    //        Flatten2D it = new Flatten2D(lists);
    //        while (it.hasNext()) {
    //            System.out.println(it.next());;
    //        }

    minJumps(new int[] {2, 3, 1, 1, 4}, 5, 1);
  }

  static int minJumps(int[] arr, int n, int start) {
    if (n == start) {
      return 0;
    }

    if (n < start) {
      return -1;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= arr[start - 1]; i++) {
      int jumps = minJumps(arr, n, start + i);
      if (jumps >= 0) min = Math.min(min, 1 + jumps);
    }

    if (min == Integer.MAX_VALUE) return -1;

    System.out.println(start + " , " + n + " = " + min);
    return min;
  }
}
