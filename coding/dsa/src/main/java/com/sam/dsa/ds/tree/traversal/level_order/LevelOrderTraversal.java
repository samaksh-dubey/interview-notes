package com.sam.dsa.ds.tree.traversal.level_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

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
