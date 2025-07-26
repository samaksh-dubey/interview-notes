package com.sam.dsa._5_tree.traversal.dfs.post_order;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class _6_MirrorImage {

  public static void convertToMirror(TreeNode root) {
    if (root == null) return;

    convertToMirror(root.left);
    convertToMirror(root.right);

    swap(root);
  }

  public static void convertToMirror_iterative(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      TreeNode curr = q.poll();
      swap(curr);

      if (curr.left != null) q.add(curr.left);

      if (curr.right != null) q.add(curr.right);
    }
  }

  private static void swap(TreeNode node) {
    if (node == null) return;

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
}
