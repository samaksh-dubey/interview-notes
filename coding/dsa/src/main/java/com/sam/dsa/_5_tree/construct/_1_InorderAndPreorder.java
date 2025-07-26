package com.sam.dsa._5_tree.construct;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class _1_InorderAndPreorder {

  public static TreeNode construct(int[] inorder, int[] preorder) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

    return construct(preorder, map, 0, preorder.length - 1, new AtomicInteger(0));
  }

  private static TreeNode construct(
      int[] preorder, Map<Integer, Integer> map, int start, int end, AtomicInteger idx) {
    if (start > end) return null;

    TreeNode node = new TreeNode(preorder[idx.getAndIncrement()]);
    int inorderIdx = map.get(node.data);

    node.left = construct(preorder, map, start, inorderIdx - 1, idx);
    node.right = construct(preorder, map, inorderIdx + 1, end, idx);

    return node;
  }
}
