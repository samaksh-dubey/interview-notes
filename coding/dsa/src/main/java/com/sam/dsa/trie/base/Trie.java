package com.sam.dsa.trie.base;

import java.util.Objects;

public class Trie {
  private Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String string) {
    char[] chars = string.toCharArray();
    Node node = root;

    for (char c: chars) {
      if (!node.hasChild(c))
        node.addChild(c);
      node = node.getChild(c);
    }

    node.setLeaf();
  }

  public boolean search(String string) {
    char[] chars = string.toCharArray();
    Node node = root;

    for (char c: chars) {
      if (!node.hasChild(c))
        return false;
      node = node.getChild(c);
    }

    return Objects.nonNull(node) && node.isLeaf();
  }
}
