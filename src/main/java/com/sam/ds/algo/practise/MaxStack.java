package com.sam.ds.algo.practise;

import java.util.*;

public class MaxStack {

    static class Node {
        Integer val;
        Integer id;

        public Node (int val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    Stack<Node> stack;
    PriorityQueue<Node> pq;
    Integer count;
    Set<Integer> removedId;

    public MaxStack() {
        this.stack = new Stack<>();
        this.pq = new PriorityQueue<>((a, b) -> {
            if (a.val.equals(b.val)) {
                return b.id - a.id;
            }
            return b.val - a.val;
        });
        this.removedId = new HashSet<>();
        this.count = 0;
    }

    public void push(int x) {
        Node node = new Node(x, count++);
        this.stack.add(node);
        this.pq.add(node);
    }

    public int pop() {
        int res = -1;
        while (!stack.isEmpty() && removedId.contains(stack.peek().id)) {
            removedId.remove(stack.pop().id);
        }
        if (!stack.isEmpty()) {
            Node node = stack.pop();
            removedId.add(node.id);
            res = node.val;
        }
        return res;
    }

    public int top() {
        int res = -1;
        while (!stack.isEmpty() && removedId.contains(stack.peek().id)) {
            removedId.remove(stack.pop().id);
        }
        if (!stack.isEmpty()) {
            Node node = stack.peek();
            res = node.val;
        }
        return res;
    }

    public int peekMax() {
        int res = -1;
        while (!pq.isEmpty() && removedId.contains(pq.peek().id)) {
            removedId.remove(pq.poll().id);
        }
        if (!pq.isEmpty()) {
            res = pq.peek().val;
        }
        return res;
    }

    public int popMax() {
        int res = -1;
        while (!pq.isEmpty() && removedId.contains(pq.peek().id)) {
            removedId.remove(pq.poll().id);
        }
        if (!pq.isEmpty()) {
            Node node = pq.poll();
            res = node.val;
            removedId.add(node.id);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}
