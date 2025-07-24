package com.sam.dsa._6_heap.problems;

import java.util.ArrayDeque;
import java.util.Queue;
import lombok.Getter;
import lombok.Setter;

public class _10_ConvertBSTtoHeapInPlace {
  public static class Node {
    @Getter @Setter private int data;
    @Getter @Setter private Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  // Function to convert a sorted linked list into a min-heap
  public static Node convertListToMinHeap(Node heapRef, Node remaining) {
    // base case: empty linked list
    if (remaining == null) {
      return heapRef;
    }

    // construct a queue to store the parent nodes
    Queue<Node> q = new ArrayDeque<>();

    // root node of the min-heap would be the front node in the sorted list
    heapRef = remaining;

    // enqueue root node
    q.add(heapRef);

    // advance the linked list to the next node
    remaining = remaining.right;

    // unlink the root node from the unprocessed linked list by
    // setting its right child as null
    heapRef.right = null;

    // loop till the end of the list is reached
    while (remaining != null) {
      // dequeue next node
      Node parent = q.poll();

      // process next node in the linked list
      Node next = remaining;

      // enqueue next node
      q.add(next);

      // advance the linked list to the next node
      remaining = remaining.right;

      // unlink the next node from the unprocessed linked list by
      // setting its right child as null
      next.right = null;

      // set the next node as the left child of the parent
      parent.left = next;

      if (remaining != null) {
        // process next node in the linked list
        next = remaining;

        // enqueue next node
        q.add(next);

        // advance the linked list to the next node
        remaining = remaining.right;

        // unlink the next node from the unprocessed linked list by
        // setting its right child as null
        next.right = null;

        // set the next node as the right child of the parent
        parent.right = next;
      }
    }

    return heapRef;
  }

  private static Node push(Node node, Node head) {
    node.setRight(head);
    return node;
  }

  private static Node convertToList(Node root, Node head) {
    if (root == null) return head;

    head = convertToList(root.getRight(), head);
    head = push(root, head);
    head = convertToList(root.getLeft(), head);

    root.setLeft(null);
    return head;
  }

  // Function to convert a BST into a min-heap without using
  // any auxiliary space
  public static Node convert(Node root) {
    // base case
    if (root == null) {
      return null;
    }

    // points to the head of the linked list
    Node head = null;

    // Convert the BST into a sorted linked list
    head = convertToList(root, head);

    // Convert the sorted list into a min-heap
    root = convertListToMinHeap(root, head);

    return root;
  }
}
