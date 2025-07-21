package com.sam.dsa.tree.traversal;

import com.sam.dsa.tree.node.Node;

/**
 * pre order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class PreOrderRecursive implements ITraversal {

  public void traverse(Node root) {
    if (root != null) {
      System.out.println(root.getData() + "  ");
      traverse(root.getLeft());
      traverse(root.getRight());
    }
  }
}
