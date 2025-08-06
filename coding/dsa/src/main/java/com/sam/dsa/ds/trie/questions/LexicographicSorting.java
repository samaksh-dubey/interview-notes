package com.sam.dsa.ds.trie.questions;

import com.sam.dsa.ds.trie.base.Node;
import com.sam.dsa.ds.trie.base.Trie;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LexicographicSorting {
  public static List<String> lexicographicSort(String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    List<String> sorted = new ArrayList<>();

    Stack<Node> stack = new Stack<>();
    stack.push(trie.getRoot());
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node.isLeaf()) {
        sorted.add(node.getKey());
      }

      List<Node> children = new ArrayList<>();
      node.getChildren()
          .forEach(
              ((key, val) -> {
                children.add(val);
              }));
      for (Node child : children.reversed()) {
        stack.push(child);
      }
    }

    return sorted;
  }
}
