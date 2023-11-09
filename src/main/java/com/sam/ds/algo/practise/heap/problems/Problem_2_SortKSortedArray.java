package com.sam.ds.algo.practise.heap.problems;

import com.sam.ds.algo.practise.heap.base.Heap;
import com.sam.ds.algo.practise.heap.base.MinHeap;

import java.util.Arrays;

public class Problem_2_SortKSortedArray {

    static void sort(int[] A, int K) {
        int N = A.length, j = 0;
        if (N == 0)
            return;

        Heap heap = new MinHeap();
        for (int i = 0; i < K + 1; i++)
            heap.insert(A[i]);

        for (int i = K + 1; i < N; i++) {
            A[j++] = heap.poll();
            heap.insert(A[i]);
        }

        while(!heap.isEmpty())
            A[j++] = heap.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;
        sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
