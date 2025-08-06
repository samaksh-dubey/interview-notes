package com.sam.dsa.ds.tree.construct;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PreorderAndPostorder {

  public static TreeNode construct(int[] preorder, int[] postorder) {
    if (postorder.length == 0) return null;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < postorder.length; i++) map.put(postorder[i], i);

    AtomicInteger pIndex = new AtomicInteger(0);

    return construct(preorder, pIndex, 0, preorder.length - 1, map);
  }

  private static TreeNode construct(
      int[] preorder, AtomicInteger pIndex, int start, int end, Map<Integer, Integer> map) {
    TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);

    if (pIndex.get() == preorder.length) return root;

    int index = map.get(preorder[pIndex.get()]);

    if (start <= index && index + 1 <= end - 1) {
      root.left = construct(preorder, pIndex, start, index, map);
      root.right = construct(preorder, pIndex, index + 1, end - 1, map);
    }

    return root;
  }
}
