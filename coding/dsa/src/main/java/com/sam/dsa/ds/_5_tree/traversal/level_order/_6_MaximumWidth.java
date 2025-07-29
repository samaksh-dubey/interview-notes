package com.sam.dsa.ds._5_tree.traversal.level_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/** Find maximum width at a level https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/ */
public class _6_MaximumWidth {

  public static int maximumWidth(TreeNode root) {
    int maxWidth = -1;
    if (root != null) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        int count = queue.size();

        maxWidth = Math.max(count, maxWidth);

        while (count-- > 0) {
          TreeNode temp = queue.remove();

          if (temp.left != null) queue.add(temp.left);

          if (temp.right != null) queue.add(temp.right);
        }
      }
    }
    return maxWidth;
  }
}
