package com.sam.dsa.ds._5_tree.traversal.level_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class _3_CompleteTree {

  public static boolean isComplete(TreeNode root) {
    if (root == null) return true;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    TreeNode front;
    boolean flag = false;

    while (!queue.isEmpty()) {
      front = queue.poll();

      if (flag && (front.left != null || front.right != null)) return false;

      if (front.left == null && front.right != null) return false;

      if (front.left != null) queue.add(front.left);
      else flag = true;

      if (front.right != null) queue.add(front.right);
      else flag = true;
    }

    return true;
  }
}
