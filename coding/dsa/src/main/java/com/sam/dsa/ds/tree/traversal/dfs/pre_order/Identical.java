package com.sam.dsa.ds.tree.traversal.dfs.pre_order;

import com.sam.dsa.ds.tree.node.TreeNode;

public class Identical {

  public static boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;

    return (root1 != null && root2 != null)
        && (root1.data == root2.data)
        && isIdentical(root1.left, root2.left)
        && isIdentical(root1.right, root2.right);
  }
}
