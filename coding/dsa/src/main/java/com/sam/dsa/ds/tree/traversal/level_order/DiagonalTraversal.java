package com.sam.dsa.ds.tree.traversal.level_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DiagonalTraversal {

  public static List<List<Integer>> diagonalTraversal(TreeNode root) {
    List<List<Integer>> diagonals = new ArrayList<>();

    Queue<TreeNode> q1 = new ArrayDeque<>();
    Queue<TreeNode> q2 = new ArrayDeque<>();

    TreeNode curr = root;
    while (curr != null) {
      q1.add(curr);
      curr = curr.right;
    }

    while (!q1.isEmpty()) {
      List<Integer> diagonal = new ArrayList<>();

      while (!q1.isEmpty()) {
        TreeNode node = q1.poll();
        diagonal.add(node.data);

        if (node.left != null) q2.add(node.left);
      }

      diagonals.add(diagonal);

      while (!q2.isEmpty()) {
        TreeNode node = q2.poll();
        while (node != null) {
          q1.add(node);
          node = node.right;
        }
      }
    }

    return diagonals;
  }
}
