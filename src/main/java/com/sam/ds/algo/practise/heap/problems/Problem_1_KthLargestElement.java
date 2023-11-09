package com.sam.ds.algo.practise.heap.problems;

import com.sam.ds.algo.practise.heap.base.Heap;
import com.sam.ds.algo.practise.heap.base.MinHeap;

public class Problem_1_KthLargestElement {

    static int kthLargest(int[] A, int K) {
        if(K < 1 || K > A.length)
            return Integer.MIN_VALUE;

        int kthLargest = Integer.MIN_VALUE;
        Heap heap = new MinHeap();
        int i;

        for (i = 0; i < K; i++) {
            heap.insert(A[i]);
        }

        for (i = K; i < A.length; i++) {
            if (heap.peek() != null && A[i] > heap.peek()) {
               heap.poll();
               heap.insert(A[i]);
            }
        }

        if(heap.peek() != null)
            kthLargest = heap.poll();

        return kthLargest;
    }

    public static void main(String[] args) {
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 0));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 1));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 2));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 3));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 4));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 5));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 6));
        System.out.println(kthLargest(new int[] {7, 4, 6, 3, 9, 1}, 7));
    }
}
