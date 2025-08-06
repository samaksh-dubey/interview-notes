package com.sam.dsa.ds.tree.traversal.dfs.post_order;

import com.sam.dsa.ds.tree.node.TreeNode;

public class MaxSumPath {

  public static int maxSumPath(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;

    if (root.left == null && root.right == null) {
      return root.data;
    }

    int left = maxSumPath(root.left);
    int right = maxSumPath(root.right);

    return root.data + Math.max(left, right);
  }
}
