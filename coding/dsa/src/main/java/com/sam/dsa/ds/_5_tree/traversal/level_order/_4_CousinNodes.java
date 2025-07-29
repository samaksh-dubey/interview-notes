package com.sam.dsa.ds._5_tree.traversal.level_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Cousins of a particular node
 * https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
 */
public class _4_CousinNodes {

  public static void findCousins(TreeNode root, int key) {
    if (root != null && !(root.left == null && root.right == null)) {
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      boolean found = false;

      while (!queue.isEmpty() && !found) {
        int count = queue.size();

        while (count-- > 0) {
          TreeNode temp = queue.poll();

          assert temp != null;

          if ((temp.left != null && temp.left.data == key)
              || (temp.right != null && temp.right.data == key)) {
            found = true;
          } else {
            if (temp.left != null) queue.add(temp.left);

            if (temp.right != null) queue.add(temp.right);
          }
        }
      }

      queue.forEach(
          node -> {
            System.out.print(node.data + " ");
          });
    }
  }
}
