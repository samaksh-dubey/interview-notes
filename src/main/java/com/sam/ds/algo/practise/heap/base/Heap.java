package com.sam.ds.algo.practise.heap.base;

public interface Heap {
    void insert(int data);
    Integer poll();
    Integer peek();
    int size();
    boolean isEmpty();
}
