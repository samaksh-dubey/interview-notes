package com.sam.dsa.ds.bst;

import com.sam.dsa.ds.tree.node.TreeNode;

public class InorderSuccessor {

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
