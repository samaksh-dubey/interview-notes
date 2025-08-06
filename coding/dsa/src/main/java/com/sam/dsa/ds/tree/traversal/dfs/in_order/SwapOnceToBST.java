package com.sam.dsa.ds.tree.traversal.dfs.in_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicReference;

// https://www.techiedelight.com/fix-binary-tree-one-swap-bst/
public class SwapOnceToBST {

  public static void correctBST(TreeNode root) {
    AtomicReference<TreeNode> x = new AtomicReference<>(null);
    AtomicReference<TreeNode> y = new AtomicReference<>(null);

    AtomicReference<TreeNode> prev = new AtomicReference<>(new TreeNode(Integer.MIN_VALUE));

    correctBST(root, x, y, prev);

    if (x.get() != null && y.get() != null) {
      int temp = x.get().data;
      x.get().data = y.get().data;
      y.get().data = temp;
    }
  }

  public static void correctBST(
      TreeNode root,
      AtomicReference<TreeNode> x,
      AtomicReference<TreeNode> y,
      AtomicReference<TreeNode> prev) {
    if (root == null) return;

    correctBST(root.left, x, y, prev);

    if (root.data < prev.get().data) {
      if (x.get() == null) {
        x.set(prev.get());
      }

      y.set(root);
    }

    prev.set(root);
    correctBST(root.right, x, y, prev);
  }
}
