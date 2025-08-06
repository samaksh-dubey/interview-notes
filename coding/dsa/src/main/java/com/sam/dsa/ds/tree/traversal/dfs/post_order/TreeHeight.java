package com.sam.dsa.ds.tree.traversal.dfs.post_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicBoolean;

public class TreeHeight {

  public static int height(TreeNode root) {
    if (root == null) return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }

  public static boolean isHeightBalanced(TreeNode root) {
    AtomicBoolean isBalanced = new AtomicBoolean(true);
    isHeightBalanced(root, isBalanced);
    return isBalanced.get();
  }

  private static int isHeightBalanced(TreeNode root, AtomicBoolean isBalanced) {
    if (root == null) return 0;

    int left = isHeightBalanced(root.left, isBalanced);
    int right = isHeightBalanced(root.right, isBalanced);

    if (Math.abs(left - right) > 1) isBalanced.set(false);

    return 1 + Math.max(left, right);
  }

  // Q:
  // https://www.techiedelight.com/calculate-height-binary-tree-leaf-nodes-forming-circular-doubly-linked-list/
  public static int heightDoublyLeaf(TreeNode node) {
    if (node == null) return 0;

    if ((node.left != null && node.left.right == node)
        && (node.right != null && node.right.left == node)) {
      return 1;
    }

    return 1 + Math.max(heightDoublyLeaf(node.left), heightDoublyLeaf(node.right));
  }
}
