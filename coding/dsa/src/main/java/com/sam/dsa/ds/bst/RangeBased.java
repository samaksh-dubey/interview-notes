package com.sam.dsa.ds.bst;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class RangeBased {

  // https://www.techiedelight.com/remove-nodes-bst-keys-outside-valid-range/
  public static TreeNode truncate(TreeNode root, int low, int high) {
    if (root == null) {
      return root;
    }

    root.left = truncate(root.left, low, high);
    root.right = truncate(root.right, low, high);

    if (root.data < low) {
      root = root.right;
    } else if (root.data > high) {
      root = root.left;
    }

    return root;
  }

  // https://www.techiedelight.com/count-subtrees-bst-whose-nodes-within-range/
  public static boolean findSubTrees(TreeNode root, int low, int high, AtomicInteger count) {
    if (root == null) {
      return true;
    }

    boolean left = findSubTrees(root.left, low, high, count);
    boolean right = findSubTrees(root.right, low, high, count);

    if (left && right && (root.data >= low && root.data <= high)) {
      count.incrementAndGet();
      return true;
    }

    return false;
  }
}
