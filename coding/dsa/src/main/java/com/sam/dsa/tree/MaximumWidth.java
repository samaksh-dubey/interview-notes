package com.sam.dsa.tree;

import com.sam.dsa.tree.node.Node;
import java.util.LinkedList;
import java.util.Queue;

/** Find maximum width at a level https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/ */
public class MaximumWidth {

  public static int maximumWidth(Node root) {
    int maxWidth = -1;
    if (root != null) {
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        int count = queue.size();

        maxWidth = Math.max(count, maxWidth);

        while (count-- > 0) {
          Node temp = queue.remove();

          if (temp.getLeft() != null) queue.add(temp.getLeft());

          if (temp.getRight() != null) queue.add(temp.getRight());
        }
      }
    }
    return maxWidth;
  }
}
