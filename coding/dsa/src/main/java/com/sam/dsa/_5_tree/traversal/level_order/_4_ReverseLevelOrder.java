package com.sam.dsa._5_tree.traversal.level_order;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class _4_ReverseLevelOrder {

  public static void reverseLevelOrder(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> stack = new Stack<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      stack.push(node);

      if (node.right != null) queue.add(node.right);
      if (node.left != null) queue.add(node.left);
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop().data);
    }
  }
}
