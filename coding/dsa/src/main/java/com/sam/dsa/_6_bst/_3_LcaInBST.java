package com.sam.dsa._6_bst;

import com.sam.dsa._5_tree.node.TreeNode;

public class _3_LcaInBST {

  public static TreeNode lca(TreeNode root, int x, int y) {
    if (root == null) return null;

    if (root.data > Math.max(x, y)) return lca(root.left, x, y);

    if (root.data < Math.min(x, y)) return lca(root.right, x, y);

    return root;
  }
}
