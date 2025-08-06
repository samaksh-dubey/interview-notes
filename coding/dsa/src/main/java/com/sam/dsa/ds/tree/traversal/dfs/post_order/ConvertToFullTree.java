package com.sam.dsa.ds.tree.traversal.dfs.post_order;

import com.sam.dsa.ds.tree.node.TreeNode;

public class ConvertToFullTree {

  public static TreeNode truncate(TreeNode root) {
    if (root == null) return null;

    root.left = truncate(root.left);
    root.right = truncate(root.right);

    if ((root.left != null && root.right != null) || (root.left == null && root.right == null))
      return root;

    return (root.left != null) ? root.left : root.right;
  }
}
