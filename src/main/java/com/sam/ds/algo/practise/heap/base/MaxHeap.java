package com.sam.ds.algo.practise.heap.base;

public class MaxHeap extends AbstractHeap {

    @Override
    protected void heapifyDown(int i) {
        if(i == size())
            return;

        int largest = i;

        if (left(i) < size() && list.get(left(i)) > list.get(largest))
            largest = left(i);

        if (right(i) < size() && list.get(right(i)) > list.get(largest))
            largest = right(i);

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    @Override
    protected void heapifyUp(int i) {
        if (i > 0 && list.get(i) > list.get(parent(i))) {
            swap(i, parent(i));
            heapifyUp(parent(i));
        }
    }
}
