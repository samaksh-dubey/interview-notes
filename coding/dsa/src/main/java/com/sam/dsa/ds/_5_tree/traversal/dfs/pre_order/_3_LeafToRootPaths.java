package com.sam.dsa.ds._5_tree.traversal.dfs.pre_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class _3_LeafToRootPaths {

  public static List<List<TreeNode>> leafToRoot(TreeNode node) {
    List<List<TreeNode>> paths = new ArrayList<>();
    List<TreeNode> path = new ArrayList<>();
    leafToRoot(node, path, paths);
    return paths;
  }

  private static void leafToRoot(TreeNode node, List<TreeNode> path, List<List<TreeNode>> paths) {
    if (node == null) return;

    path.add(node);

    if (node.left == null && node.right == null) {
      paths.add(new ArrayList<>(path));
    }

    leafToRoot(node.left, path, paths);
    leafToRoot(node.right, path, paths);

    path.removeLast();
  }
}
