package com.sam.dsa.ds._5_tree.traversal.dfs.post_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

// https://www.techiedelight.com/find-maximum-difference-node-descendants/
public class _5_MaxDiffNodeAndSubNode {

  public static int findMaxDifference(TreeNode root) {
    AtomicInteger diff = new AtomicInteger(Integer.MIN_VALUE);
    findMaxDifference(root, diff);

    return diff.get();
  }

  public static int findMaxDifference(TreeNode root, AtomicInteger diff) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    int left = findMaxDifference(root.left, diff);
    int right = findMaxDifference(root.right, diff);

    int d = Integer.MIN_VALUE;
    if (Math.min(left, right) != Integer.MAX_VALUE) {
      d = root.data - Math.min(left, right);
    }

    diff.set(Math.max(diff.get(), d));

    return Math.min(Math.min(left, right), root.data);
  }
}
