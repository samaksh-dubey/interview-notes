package com.sam.dsa._5_tree;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Cousins of a particular node
 * https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
 */
public class CousinNodes {

  public static void findCousins(TreeNode root, int key) {
    if (root != null && !(root.getLeft() == null && root.getRight() == null)) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      boolean found = false;

      while (!queue.isEmpty() && !found) {
        int count = queue.size();

        while (count-- > 0) {
          TreeNode temp = queue.remove();

          if (temp.getLeft().getData() == key || temp.getRight().getData() == key) {
            found = true;
          } else {
            if (temp.getLeft() != null) queue.add(temp.getLeft());

            if (temp.getRight() != null) queue.add(temp.getRight());
          }
        }
      }

      queue.forEach(
          node -> {
            System.out.print(node.getData() + " ");
          });
    }
  }
}
