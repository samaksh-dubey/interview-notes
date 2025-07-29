package com.sam.dsa.ds._6_bst;

import com.sam.dsa.ds._5_tree.node.TreeNode;

public class _1_BstOperations {

  public static TreeNode insert(TreeNode root, int key) {
    if (root == null) return new TreeNode(key);

    if (key < root.data) {
      root.left = insert(root.left, key);
    } else {
      root.right = insert(root.right, key);
    }

    return root;
  }

  public static boolean search(TreeNode root, int key) {
    if (root == null) return false;

    if (root.data == key) return true;

    if (key < root.data) return search(root.left, key);
    else return search(root.right, key);
  }
}
