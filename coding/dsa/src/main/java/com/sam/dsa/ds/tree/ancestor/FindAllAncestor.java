package com.sam.dsa.ds.tree.ancestor;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FindAllAncestor {

  public static List<TreeNode> ancestors(TreeNode root, TreeNode x) {
    List<TreeNode> path = new ArrayList<>();
    AtomicReference<List<TreeNode>> ancestorsRef = new AtomicReference<>();
    ancestors(root, x, path, ancestorsRef);
    return ancestorsRef.get();
  }

  private static void ancestors(
      TreeNode root,
      TreeNode x,
      List<TreeNode> path,
      AtomicReference<List<TreeNode>> ancestorsRef) {
    if (root == null) return;

    if (root.data == x.data) {
      ancestorsRef.set(new ArrayList<>(path));
    } else {
      path.add(root);
      ancestors(root.left, x, path, ancestorsRef);
      ancestors(root.right, x, path, ancestorsRef);
      path.removeLast();
    }
  }
}
