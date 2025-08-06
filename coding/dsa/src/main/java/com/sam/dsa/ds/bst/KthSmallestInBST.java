package com.sam.dsa.ds.bst;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestInBST {

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
