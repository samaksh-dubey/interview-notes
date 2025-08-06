package com.sam.dsa.ds.tree.traversal.dfs.pre_order;

import com.sam.dsa.ds.tree.node.TreeNode;

public class Symmetric {

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    return isSymmetric(root.left, root.right);
  }

  private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;

    return (left != null && right != null)
        && isSymmetric(left.left, right.right)
        && isSymmetric(left.right, right.left);
  }
}
