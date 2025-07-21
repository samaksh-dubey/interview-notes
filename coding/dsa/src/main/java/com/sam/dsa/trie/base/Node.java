package com.sam.dsa.trie.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

class Node {
  private final Map<Character, Node> children;
  @Getter private boolean isLeaf;

  public Node() {
    this.children = new HashMap<>();
  }

  public boolean hasChild(Character c) {
    return this.children.containsKey(c);
  }

  public void addChild(Character c) {
    this.children.putIfAbsent(c, new Node());
  }

  public Node getChild(char c) {
    return this.children.get(c);
  }

  public void setLeaf() {
    this.isLeaf = true;
  }

}