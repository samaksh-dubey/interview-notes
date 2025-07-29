package com.sam.dsa.ds._5_tree.traversal.dfs.post_order;

import com.sam.dsa.ds._5_tree.node.TreeNode;

// https://www.techiedelight.com/convert-normal-binary-tree-left-child-right-sibling-binary-tree/
public class _9_LeftChildRightSibling {

  public static void convert(TreeNode root) {
    if (root == null) return;

    convert(root.right);
    convert(root.left);

    if (root.left != null) {
      root.left.right = root.right;
      root.right = null;
    } else {
      root.left = root.right;
      root.right = null;
    }
  }
}
