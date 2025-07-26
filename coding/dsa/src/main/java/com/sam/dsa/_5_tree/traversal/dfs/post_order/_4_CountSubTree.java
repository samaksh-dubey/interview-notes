package com.sam.dsa._5_tree.traversal.dfs.post_order;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

// https://www.techiedelight.com/count-subtrees-value-nodes-binary-tree/
public class _4_CountSubTree {

  public static int countSubtrees(TreeNode root) {
    AtomicInteger count = new AtomicInteger(0);
    countSubtrees(root, count);
    return count.get();
  }

  public static int countSubtrees(TreeNode root, AtomicInteger count) {
    if (root == null) return Integer.MIN_VALUE;

    if (root.left == null && root.right == null) {
      count.incrementAndGet();
      return root.data;
    }

    int left = countSubtrees(root.left, count);
    int right = countSubtrees(root.right, count);

    if ((left == Integer.MIN_VALUE && right == root.data)
        || (right == Integer.MIN_VALUE && left == root.data)
        || (left == right && left == root.data)) {
      count.incrementAndGet();
      return root.data;
    }

    return Integer.MAX_VALUE;
  }
}
