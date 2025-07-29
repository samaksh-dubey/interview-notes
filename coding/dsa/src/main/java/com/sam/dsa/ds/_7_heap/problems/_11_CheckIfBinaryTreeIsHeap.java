package com.sam.dsa.ds._7_heap.problems;

import com.sam.dsa.ds._7_heap.base.HeapUtils;
import lombok.Getter;
import lombok.Setter;

public class _11_CheckIfBinaryTreeIsHeap {

  public static class Node {
    @Getter @Setter private int data;
    @Getter @Setter private Node left, right;

    public Node(int data) {
      this.data = data;
    }
  }

  // This is only half correct. We also need to check if the tree is balanced or not.
  public static boolean isHeap(Node root, int index, int size) {
    // base condition
    if (root == null) return true;

    // check if balanced tree property is violated
    if (index >= size) return false;

    // if left element exists and violated heap property
    if (root.getLeft() != null && root.getLeft().getData() > root.getData()) {
      return false;
    }

    // if right element exists and violated heap property
    if (root.getRight() != null && root.getRight().getData() > root.getData()) {
      return false;
    }

    // check left subtree and right subtree
    return (root.getLeft() == null || isHeap(root.getLeft(), HeapUtils.left(index), size))
        && (root.getRight() == null || isHeap(root.getRight(), HeapUtils.right(index), size));
  }
}
