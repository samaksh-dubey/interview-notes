package com.sam.dsa.ds._5_tree.traversal.dfs.in_order;

public class _4_NextPointer {
  public static class Node {
    int data;
    Node left = null, right = null, next = null;

    Node(int data) {
      this.data = data;
    }
  }

  private static Node setNextNode(Node curr, Node prev) {
    if (curr == null) {
      return prev;
    }

    prev = setNextNode(curr.left, prev);

    if (prev != null) {
      prev.next = curr;
    }

    return setNextNode(curr.right, curr);
  }

  public static void inorderSuccessor(Node root) {
    setNextNode(root, null);
  }
}
