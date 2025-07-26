package com.sam.dsa._5_tree.view;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/** https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/ */
public class _1_TopView {

  static class ViewNode {
    TreeNode node;
    int horizontalDistance;

    ViewNode(TreeNode node, int horizontalDistance) {
      this.node = node;
      this.horizontalDistance = horizontalDistance;
    }
  }

  public void view(TreeNode root) {
    if (root != null) {
      Map<Integer, ViewNode> hdToNodeMap = new TreeMap<>();
      Queue<ViewNode> queue = new LinkedList<>();

      queue.add(new ViewNode(root, 0));

      while (!queue.isEmpty()) {
        ViewNode current = queue.poll();
        hdToNodeMap.putIfAbsent(current.horizontalDistance, current);

        if (current.node.left != null)
          queue.add(new ViewNode(current.node.left, current.horizontalDistance - 1));
        if (current.node.right != null)
          queue.add(new ViewNode(current.node.right, current.horizontalDistance + 1));
      }

      hdToNodeMap.forEach(
          (key, value) -> {
            System.out.print(value);
          });
    }
  }
}
