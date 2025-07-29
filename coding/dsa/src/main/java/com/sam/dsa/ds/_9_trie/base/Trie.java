package com.sam.dsa.ds._9_trie.base;

import java.util.Objects;
import java.util.Stack;
import lombok.Getter;

public class Trie {
  @Getter protected Node root;

  public Trie() {
    this.root = new Node('/', "");
  }

  public void insert(String key) {
    char[] chars = key.toCharArray();
    Node node = root;

    for (char c : chars) {
      if (!node.hasChild(c)) node.addChild(c);
      node = node.getChild(c);
    }

    node.setLeaf(true);
    node.incrementCount();
  }

  public boolean search(String string) {
    char[] chars = string.toCharArray();
    Node node = root;

    for (char c : chars) {
      if (!node.hasChild(c)) return false;
      node = node.getChild(c);
    }

    return Objects.nonNull(node) && node.isLeaf();
  }

  public void delete(String word) {
    char[] characters = word.toCharArray();
    Stack<Node> stack = buildDeletionStack(characters);

    if (Objects.nonNull(stack)) {
      Node node = stack.pop();

      boolean shouldDelete = false;
      if (node.isLeaf()) {
        node.setLeaf(false);
        shouldDelete = node.isEmpty();
      }

      int i = stack.size() - 1;
      while (!stack.isEmpty() && shouldDelete) {
        node = stack.pop();
        char ch = characters[i--];

        node.remove(ch);
        shouldDelete = !node.isLeaf() && node.isEmpty();
      }
    }
  }

  private Stack<Node> buildDeletionStack(char[] characters) {
    Stack<Node> stack = new Stack<>();
    Node current = root;
    stack.push(current);

    for (char c : characters) {
      current = current.getChild(c);
      if (current == null) return null;
      stack.push(current);
    }
    return stack;
  }
}
