package com.sam.dsa.tree.traversal;

import com.sam.dsa.tree.node.Node;

/**
 * post order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class PostOrderRecursive implements ITraversal {

  public void traverse(Node root) {
    if (root != null) {
      traverse(root.getLeft());
      traverse(root.getRight());
      System.out.println(root.getData() + "  ");
    }
  }
}
