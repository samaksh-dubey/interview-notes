package com.sam.dsa._6_bst;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class _5_FloorAndCeil {

  public static int[] getFloorAndCeil(TreeNode root, int k) {
    int floor = floor(root, new AtomicInteger(Integer.MIN_VALUE), k);
    int ceil = ceil(root, new AtomicInteger(Integer.MAX_VALUE), k);
    return new int[] {floor, ceil};
  }

  private static int ceil(TreeNode root, AtomicInteger ceil, int k) {
    if (root == null) return ceil.get();

    if (root.data < k) {
      return floor(root.right, ceil, k);
    } else {
      ceil.set(root.data);
      if (root.data > k) {
        return floor(root.left, ceil, k);
      } else {
        return ceil.get();
      }
    }
  }

  private static int floor(TreeNode root, AtomicInteger floor, int k) {
    if (root == null) return floor.get();

    if (root.data > k) {
      return floor(root.left, floor, k);
    } else {
      floor.set(root.data);
      if (root.data < k) {
        return floor(root.right, floor, k);
      } else {
        return floor.get();
      }
    }
  }
}
