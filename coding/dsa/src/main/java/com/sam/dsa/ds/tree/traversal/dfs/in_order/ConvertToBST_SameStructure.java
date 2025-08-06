package com.sam.dsa.ds.tree.traversal.dfs.in_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ConvertToBST_SameStructure {

  public static void convertToBST(TreeNode root) {
    Set<Integer> set = new TreeSet<>();
    extractKeys(root, set);
    populateKeys(root, set.iterator());
  }

  private static void extractKeys(TreeNode root, Set<Integer> set) {
    if (root == null) return;

    extractKeys(root.left, set);
    set.add(root.data);
    extractKeys(root.right, set);
  }

  private static void populateKeys(TreeNode root, Iterator<Integer> iterator) {
    if (root == null) return;

    populateKeys(root.left, iterator);
    root.data = iterator.next();
    populateKeys(root.right, iterator);
  }
}
