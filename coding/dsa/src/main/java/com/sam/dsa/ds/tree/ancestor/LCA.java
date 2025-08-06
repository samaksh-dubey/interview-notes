package com.sam.dsa.ds.tree.ancestor;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicReference;

public class LCA {

  public static TreeNode lca(TreeNode root, TreeNode x, TreeNode y) {
    AtomicReference<TreeNode> lcaRef = new AtomicReference<>(null);
    lca(root, x, y, lcaRef);
    return lcaRef.get();
  }

  private static boolean lca(
      TreeNode root, TreeNode x, TreeNode y, AtomicReference<TreeNode> lcaRef) {
    if (root == null) return false;

    if (root.data == x.data || root.data == y.data) {
      lcaRef.set(root);
      return true;
    }

    boolean left = lca(root.left, x, y, lcaRef);
    boolean right = lca(root.right, x, y, lcaRef);

    if (left && right) {
      lcaRef.set(root);
      return true;
    }

    return left || right;
  }

  /// LCA based problem -
  // https://www.techiedelight.com/distance-between-given-pairs-of-nodes-binary-tree/
  public static int shortestDistance(TreeNode root, TreeNode x, TreeNode y) {
    return 0;
  }
}
