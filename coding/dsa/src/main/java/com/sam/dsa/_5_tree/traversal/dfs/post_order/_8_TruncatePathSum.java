package com.sam.dsa._5_tree.traversal.dfs.post_order;

import com.sam.dsa._5_tree.node.TreeNode;

public class _8_TruncatePathSum {

  public static TreeNode truncate(TreeNode root, int k) {
    return truncate(root, k, 0);
  }

  public static TreeNode truncate(TreeNode curr, int k, int target) {
    if (curr == null) return null;

    target = target + (curr.data);

    curr.left = truncate(curr.left, k, target);
    curr.right = truncate(curr.right, k, target);

    if (target < k && (curr.left == null && curr.right == null)) return null;

    return curr;
  }
}
