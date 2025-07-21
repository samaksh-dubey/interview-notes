package com.sam.dsa.trie.base;

import java.util.Map;
import java.util.TreeMap;
import lombok.Getter;
import lombok.Setter;

public class Node {
  private final char character;
  @Getter private final String key;
  @Getter private final Map<Character, Node> children;
  @Getter @Setter private boolean isLeaf;
  @Getter int count;

  public Node(char character, String key) {
    this.character = character;
    this.key = key;
    this.children = new TreeMap<>(Character::compare);
  }

  public boolean hasChild(Character ch) {
    return this.children.containsKey(ch);
  }

  public Node getChild(char ch) {
    return this.children.get(ch);
  }

  public void addChild(Character ch) {
    this.children.putIfAbsent(ch, new Node(ch, key + ch));
  }

  public void remove(char ch) {
    this.children.remove(ch);
  }

  public int childCount() {
    return this.children.size();
  }

  public boolean isEmpty() {
    return this.children.isEmpty();
  }

  public void incrementCount() {
    this.count = this.count + 1;
  }

  @Override
  public String toString() {
    return String.valueOf(character);
  }
}
