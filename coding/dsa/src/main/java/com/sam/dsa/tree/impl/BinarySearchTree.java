package com.sam.dsa.tree.impl;

import com.sam.dsa.tree.node.Node;

public class BinarySearchTree extends BaseTree {

  public void insertUtil(int key) {
    root = insert(root, key);
  }

  private Node insert(Node node, int key) {
    if (node == null) {
      return new Node(key);
    }

    if (key < node.getData()) {
      node.setLeft(insert(node.getLeft(), key));
    } else if (key > node.getData()) {
      node.setRight(insert(node.getRight(), key));
    }

    return node;
  }
}
