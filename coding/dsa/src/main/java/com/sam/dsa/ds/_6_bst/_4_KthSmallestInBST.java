package com.sam.dsa.ds._6_bst;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class _4_KthSmallestInBST {

  public static TreeNode kthSmallest(TreeNode root, int k) {
    return kthSmallest(root, new AtomicInteger(0), k);
  }

  private static TreeNode kthSmallest(TreeNode root, AtomicInteger count, int k) {
    if (root == null) return null;

    TreeNode left = kthSmallest(root.left, count, k);

    if (left != null) return left;

    if (count.incrementAndGet() == k) return root;

    return kthSmallest(root.right, count, k);
  }
}
