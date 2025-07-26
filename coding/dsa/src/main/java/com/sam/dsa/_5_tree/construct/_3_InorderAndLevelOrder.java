package com.sam.dsa._5_tree.construct;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class _3_InorderAndLevelOrder {

  public static TreeNode construct(int[] in, int[] level) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      map.put(level[i], i);
    }

    return construct(in, 0, in.length - 1, map);
  }

  public static TreeNode construct(int[] inorder, int start, int end, Map<Integer, Integer> map) {
    if (start > end) return null;

    int index = start;
    for (int j = start + 1; j <= end; j++) {
      if (map.get(inorder[j]) < map.get(inorder[index])) {
        index = j;
      }
    }

    TreeNode root = new TreeNode(inorder[index]);
    root.left = construct(inorder, start, index - 1, map);
    root.right = construct(inorder, index + 1, end, map);

    return root;
  }
}
