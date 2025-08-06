package com.sam.dsa.ds.tree.traversal.level_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class AlternateLevelOrder {

  public static void printNodes(TreeNode root) {
    if (root == null) return;

    System.out.print(root.data + " ");

    Queue<TreeNode> first = new ArrayDeque<>();
    Queue<TreeNode> second = new ArrayDeque<>();

    if (root.left != null && root.right != null) {
      first.add(root.left);
      second.add(root.right);
    }

    while (!first.isEmpty()) {
      int n = first.size();

      while (n-- > 0) {
        TreeNode node = first.poll();
        System.out.print(node.data + " ");

        if (node.left != null) first.add(node.left);
        if (node.right != null) first.add(node.right);

        node = second.poll();
        System.out.print(node.data + " ");

        if (node.right != null) second.add(node.right);

        if (node.left != null) second.add(node.left);
      }
    }
  }
}
