package com.sam.dsa.ds.tree.traversal.dfs.post_order;

import com.sam.dsa.ds.tree.node.TreeNode;

// https://www.techiedelight.com/convert-normal-binary-tree-left-child-right-sibling-binary-tree/
public class LeftChildRightSibling {

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
