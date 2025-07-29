package com.sam.dsa.ds._6_bst;

import com.sam.dsa.ds._5_tree.node.TreeNode;

public class _7_InorderSuccessor {

  public static TreeNode findSuccessor(TreeNode root, TreeNode succ, int key) {
    if (root == null) return succ;

    if (root.data == key) {
      if (root.right != null) {
        return findMinimum(root.right);
      }
    } else if (key < root.data) {
      succ = root;
      return findSuccessor(root.left, succ, key);
    } else {
      return findSuccessor(root.right, succ, key);
    }

    return succ;
  }

  private static TreeNode findMinimum(TreeNode root) {
    while (root.left != null) root = root.left;
    return root;
  }
}
