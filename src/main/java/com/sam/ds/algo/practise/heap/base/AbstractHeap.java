package com.sam.ds.algo.practise.heap.base;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractHeap implements Heap {

    final protected List<Integer> list;

    public AbstractHeap() {
        this.list = new LinkedList<>();
    }

    public AbstractHeap(List<Integer> list) {
        this.list = list;
        heapify();
    }

    private void heapify() {
        int i = (size() - 2) / 2;
        while(i >= 0) {
            heapifyDown(i--);
        }
    }

    protected int left(int index) {
        return 2 * index + 1;
    }

    protected int right(int index) {
        return 2 * index + 2;
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected void swap(int i, int j) {
        if (i < size() && j < size()) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    @Override
    public void insert(int data) {
        list.add(data);
        int index = list.size() - 1;
        heapifyUp(index);
    }

    @Override
    public Integer poll() {
        if (size() == 0) {
            return null;
        }

        int first = list.get(0);
        int last = list.get(size() - 1);

        list.set(0, last);
        list.remove(size() - 1);
        heapifyDown(0);

        return first;
    }

    @Override
    public Integer peek() {
        if (size() == 0) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    abstract protected void heapifyUp(int i);
    abstract protected void heapifyDown(int i);
}
