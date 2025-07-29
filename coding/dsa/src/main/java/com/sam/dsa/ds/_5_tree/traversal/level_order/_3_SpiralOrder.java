package com.sam.dsa.ds._5_tree.traversal.level_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.Stack;

public class _3_SpiralOrder {

  public static void spiralOrder(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    s1.push(root);

    while (!s1.isEmpty()) {

      while (!s1.isEmpty()) {
        TreeNode node = s1.pop();
        System.out.println(node.data);

        if (node.left != null) s2.push(node.left);

        if (node.right != null) s2.push(node.right);
      }

      while (!s2.isEmpty()) {
        TreeNode node = s2.pop();
        System.out.println(node.data);

        if (node.right != null) s1.push(node.right);

        if (node.left != null) s1.push(node.left);
      }
    }
  }
}
