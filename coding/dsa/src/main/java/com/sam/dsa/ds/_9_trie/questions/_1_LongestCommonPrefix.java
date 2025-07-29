package com.sam.dsa.ds._9_trie.questions;

import com.sam.dsa.ds._9_trie.base.Node;
import com.sam.dsa.ds._9_trie.base.Trie;
import java.util.Map;

public class _1_LongestCommonPrefix {

  public static String longestCommonPrefix(String[] words) {
    Trie trie = new Trie();
    for (String word : words) trie.insert(word);

    Node curr = trie.getRoot();
    StringBuilder sb = new StringBuilder();

    while (curr != null && !curr.isLeaf() && curr.childCount() == 1) {
      for (Map.Entry<Character, Node> entry : curr.getChildren().entrySet()) {
        sb.append(entry.getKey());
        curr = entry.getValue();
      }
    }

    return sb.toString();
  }
}
