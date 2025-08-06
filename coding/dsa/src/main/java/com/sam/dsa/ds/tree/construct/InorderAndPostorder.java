package com.sam.dsa.ds.tree.construct;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InorderAndPostorder {

  public static TreeNode construct(int[] inorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

    return construct(
        postorder, map, 0, postorder.length - 1, new AtomicInteger(postorder.length - 1));
  }

  private static TreeNode construct(
      int[] postorder, Map<Integer, Integer> map, int start, int end, AtomicInteger idx) {
    if (start > end) return null;

    TreeNode node = new TreeNode(postorder[idx.getAndDecrement()]);
    int inorderIdx = map.get(node.data);

    node.right = construct(postorder, map, inorderIdx + 1, end, idx);
    node.left = construct(postorder, map, start, inorderIdx - 1, idx);

    return node;
  }
}
