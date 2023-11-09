package com.sam.ds.algo.practise.heap.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_4_MergeMSortedLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node sort(Node[] lists) {
        Node head = null, last = null;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        for (int i = 0; i < lists.length; i++)
            queue.add(lists[i]);

        while (!queue.isEmpty()) {
            Node min = queue.poll();
            if (head == null) {
                head = last = new Node(min.data);
            } else {
                last.next = new Node(min.data);
                last = last.next;
            }

            if(min.next != null)
                queue.add(min.next);
        }

        return head;
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];

        lists[0] = new Node(1);
        lists[0].next = new Node(5);
        lists[0].next.next = new Node(7);

        lists[1] = new Node(2);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(6);
        lists[1].next.next.next = new Node(9);

        lists[2] = new Node(4);
        lists[2].next = new Node(8);
        lists[2].next.next = new Node(10);

        Node head = sort(lists);

        printList(head);
        printList(lists[0]);
        printList(lists[1]);
        printList(lists[2]);
    }

    static void printList(Node node) {
        while (node != null)
        {
            System.out.print(node.data + " —> ");
            node = node.next;
        }
        System.out.print("null\n");
    }
}
