package com.sam.dsa.trie.questions;

import com.sam.dsa.trie.base.Node;
import com.sam.dsa.trie.base.Trie;
import java.util.Stack;

public class _3_MaximumOccurringString {

  public static String maxOccurring(String[] words) {
    Trie trie = new Trie();
    for (String word : words) trie.insert(word);

    int max = 0;
    String res = null;

    Stack<Node> stack = new Stack<>();
    stack.push(trie.getRoot());
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      if (node.isLeaf()) {
        if (max < node.getCount()) {
          max = node.getCount();
          res = node.getKey();
        }
      }

      node.getChildren()
          .forEach(
              ((key, val) -> {
                stack.push(val);
              }));
    }

    return res;
  }
}
