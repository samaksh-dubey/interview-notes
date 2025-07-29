package com.sam.dsa.ds._5_tree.traversal.dfs.pre_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;

public class _2_CheckBST {

  public static boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isBST(TreeNode node, int minKey, int maxKey) {
    if (node == null) return true;

    if (node.data < minKey || node.data > maxKey) return false;

    return isBST(node.left, minKey, node.data) && isBST(node.right, node.data, maxKey);
  }
}
