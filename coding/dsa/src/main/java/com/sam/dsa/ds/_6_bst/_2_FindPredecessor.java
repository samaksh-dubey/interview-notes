package com.sam.dsa.ds._6_bst;

import com.sam.dsa.ds._5_tree.node.TreeNode;

public class _2_FindPredecessor {

  public static TreeNode findPredecessor(TreeNode root, TreeNode prec, int key) {
    if (root == null) return prec;

    if (root.data == key) {
      if (root.left != null) return findMaximum(root.left);
    } else if (key < root.data) {
      return findPredecessor(root.left, prec, key);
    } else {
      prec = root;
      return findPredecessor(root.right, prec, key);
    }
    return prec;
  }

  private static TreeNode findMaximum(TreeNode root) {
    while (root.right != null) root = root.right;

    return root;
  }
}
