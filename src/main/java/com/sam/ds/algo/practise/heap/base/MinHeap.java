package com.sam.ds.algo.practise.heap.base;

public class MinHeap extends AbstractHeap {

    @Override
    protected void heapifyDown(int i) {
        if(i == size())
            return;

        int smallest = i;

        if (left(i) < size() && list.get(left(i)) < list.get(smallest))
            smallest = left(i);

        if (right(i) < size() && list.get(right(i)) < list.get(smallest))
            smallest = right(i);

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    @Override
    protected void heapifyUp(int i) {
        if (i > 0 && list.get(i) < list.get(parent(i))) {
            swap(i, parent(i));
            heapifyUp(parent(i));
        }
    }
}
