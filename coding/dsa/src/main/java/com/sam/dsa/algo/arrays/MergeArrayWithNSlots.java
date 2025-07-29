package com.sam.dsa.algo.arrays;

public class MergeArrayWithNSlots {

  public static void merge(int[] X, int[] Y) {
    int xlen = X.length, ylen = Y.length;
    int x = 0, y = 0, pos = 0;

    while (x < xlen) {
      if (X[x] != 0) {
        X[pos++] = X[x++];
      } else {
        x++;
      }
    }

    x = pos;
    while (x < xlen) {
      X[x++] = 0;
    }

    pos--;
    x = xlen - 1;
    y = ylen - 1;
    while (x >= 0 && y >= 0 && pos >= 0) {
      X[x--] = X[pos] > Y[y] ? X[pos--] : Y[y--];
    }
    while (y >= 0) {
      X[x--] = Y[y--];
    }
    while (pos >= 0) {
      X[x--] = X[pos--];
    }
  }

  public static void main(String[] args) {
    merge(new int[] {0, 2, 0, 3, 0, 5, 6, 0, 0}, new int[] {1, 8, 9, 10, 15});
  }
}
