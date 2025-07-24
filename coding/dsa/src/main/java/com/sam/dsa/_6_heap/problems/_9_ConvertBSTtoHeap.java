package com.sam.dsa._6_heap.problems;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

public class _9_ConvertBSTtoHeap {
  public static class Node {
    @Getter @Setter private int data;
    @Getter @Setter private Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  // in inorder traversal manner add current to queue
  private static void convertToSortedQueue(Node root, Queue<Integer> keys) {
    // base case
    if (root == null) return;

    // add left subtree to queue
    convertToSortedQueue(root.getLeft(), keys);

    // add current node to queue
    keys.add(root.getData());

    // add right subtree to queue
    convertToSortedQueue(root.getRight(), keys);
  }

  private static Node convertToTree(Queue<Integer> keys) {
    if (keys == null || keys.isEmpty()) return null;

    // poll first key of the keys and add data into heapRef
    Queue<Node> queue = new LinkedList<>();
    Node heapRef = new Node(keys.poll());
    queue.add(heapRef);

    // iterate till the keys queue is not empty
    while (!keys.isEmpty()) {
      // parent in current level
      Node parent = queue.poll();

      assert parent != null;

      // add left child of parent in the next level
      if (!keys.isEmpty()) {
        parent.setLeft(new Node(keys.poll()));
        queue.add(parent.getLeft());
      }

      // add right child of parent in the next level
      if (!keys.isEmpty()) {
        parent.setRight(new Node(keys.poll()));
        queue.add(parent.getRight());
      }
    }

    return heapRef;
  }

  public static Node convert(Node root) {
    Queue<Integer> sortedList = new LinkedList<>();

    // convert the tree to sorted queue
    convertToSortedQueue(root, sortedList);

    // convert the sorted queue to heap
    return convertToTree(sortedList);
  }
}
