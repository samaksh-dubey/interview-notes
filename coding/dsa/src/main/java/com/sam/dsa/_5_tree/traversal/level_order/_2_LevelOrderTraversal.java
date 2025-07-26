package com.sam.dsa._5_tree.traversal.level_order;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class _2_LevelOrderTraversal {

  public static void levelOrder(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println(node.data);

      if (node.left != null) queue.add(node.left);

      if (node.right != null) queue.add(node.right);
    }
  }
}
