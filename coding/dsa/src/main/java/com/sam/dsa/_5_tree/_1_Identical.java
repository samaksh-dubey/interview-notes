package com.sam.dsa._5_tree;

import com.sam.dsa._5_tree.node.TreeNode;

public class _1_Identical {

  public static boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;

    return (root1 != null && root2 != null)
        && (root1.data == root2.data)
        && isIdentical(root1.left, root2.left)
        && isIdentical(root1.right, root2.right);
  }
}
