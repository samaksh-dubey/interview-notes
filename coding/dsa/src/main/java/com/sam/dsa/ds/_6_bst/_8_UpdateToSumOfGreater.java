package com.sam.dsa.ds._6_bst;

import com.sam.dsa.ds._5_tree.node.TreeNode;

public class _8_UpdateToSumOfGreater {

  public static int transform(TreeNode root, int sum_so_far) {
    if (root == null) {
      return sum_so_far;
    }

    int right = transform(root.right, sum_so_far);

    root.data += right;
    sum_so_far = root.data;

    return transform(root.left, sum_so_far);
  }
}
