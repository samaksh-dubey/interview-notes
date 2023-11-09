package com.sam.ds.algo.practise.heap.problems;

import java.util.*;

public class Problem_3_MergeMSortedArray {

    static class Node {
        int data, index, list;

        public Node(int data, int index, int list) {
            this.data = data;
            this.index = index;
            this.list = list;
        }
    }

    static List<Integer> sort(List<List<Integer>> lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        for (int i = 0; i < lists.size(); i++)
            queue.add(new Node(lists.get(i).get(0), 0, i));

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node min = queue.poll();
            result.add(min.data);
            if (lists.get(min.list).size() > min.index + 1) {
                min.data = lists.get(min.list).get(min.index + 1);
                min.index = min.index + 1;
                queue.add(min);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(10, 20, 30, 40),
                Arrays.asList(15, 25, 35),
                Arrays.asList(27, 29, 37, 48, 93),
                Arrays.asList(32, 33)
        );
        System.out.println(sort(lists));
    }
}
