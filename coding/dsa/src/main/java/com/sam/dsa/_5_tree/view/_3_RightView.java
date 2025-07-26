package com.sam.dsa._5_tree.view;

import com.sam.dsa._5_tree.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _3_RightView {

  public static void leftView(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    TreeNode curr;

    while (!queue.isEmpty()) {
      int size = queue.size();
      int i = 0;

      while (i++ < size) {
        curr = queue.poll();
        assert curr != null;

        if (i == size)
          System.out.print(curr.data + " ");

        if (curr.left != null)
          queue.add(curr.left);
        if (curr.right != null)
          queue.add(curr.right);
      }
    }
  }
}
