package com.sam.dsa;

/*
* problem:- Rotate an array to the left or right direction by count k.

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 1
*
*
*
Output :- Array = [2,3,4,5,6,7,1]

* i1 = (i1 + n - k) % n : i2 = i1 + k
*
*
Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 2
* oldIndexes[] =
* newIndex[i] = (n-k+i)%n
* newIndex[] =  [5, 6, 0, 1, 2, 3, 4]
* result[newIndex[i]] = arr[i]
* result = [
*
Output :- Array = [3,4,5,6,7,1,2]

Input :- Array = [1,2,3,4,5,6,7], direction = left, k = 8
Output :- Array = [2,3,4,5,6,7,1]

Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 3
Output :- Array = [5,6,7,1,2,3,4]

*
*
*
Input :- Array = [1,2,3,4,5,6,7], direction = right, k = 1
Output :- Array = [7,1,2,3,4,5,6]
* */
public class Test2 {

  // left == true ==> left
  // left == false ==> right
  static int[] kSort(int[] arr, int k, boolean left) {
    if (arr == null || arr.length == 0 || arr.length == 1) return arr;
    if (k == 0) return arr;
    int n = arr.length;
    int[] newIndexes = new int[n];
    for (int i = 0; i < n; i++) {
      if (left) newIndexes[i] = (n - k % n + i) % n;
      else newIndexes[i] = (k % n + i) % n;
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[newIndexes[i]] = arr[i];
    }
    return result;
  }

  public static void main(String[] args) {
    print(kSort(new int[] {1, 2, 3, 4, 5, 6, 7}, 1, true));
    print(kSort(new int[] {1, 2, 3, 4, 5, 6, 7}, 2, true));
    print(kSort(new int[] {1, 2, 3, 4, 5, 6, 7}, 8, true));
    print(kSort(new int[] {1, 2, 3, 4, 5, 6, 7}, 3, false));
    print(kSort(new int[] {1, 2, 3, 4, 5, 6, 7}, 1, false));
  }

  private static void print(int[] arr) {
    for (int a : arr) System.out.print(a + ", ");
    System.out.println();
  }
}
