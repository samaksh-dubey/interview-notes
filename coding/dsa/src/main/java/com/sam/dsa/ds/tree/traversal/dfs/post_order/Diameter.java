package com.sam.dsa.ds.tree.traversal.dfs.post_order;

import com.sam.dsa.ds.tree.node.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class Diameter {

  public static int largestDiameter(TreeNode root, AtomicInteger maxDia) {
    if (root == null) return 0;

    int left_height = largestDiameter(root.left, maxDia);
    int right_height = largestDiameter(root.right, maxDia);

    maxDia.set(Math.max(maxDia.get(), left_height + right_height + 1));

    return 1 + Math.max(left_height, right_height);
  }

  // https://www.techiedelight.com/find-maximum-sum-path-between-two-leaves-in-a-binary-tree/
  public static int maxSumDiameter(TreeNode root, AtomicInteger maxSum) {
    if (root == null) return 0;

    int leftSum = maxSumDiameter(root, maxSum);
    int rightSum = maxSumDiameter(root, maxSum);

    if (root.left == null) return rightSum + root.data;

    if (root.right == null) return leftSum + root.data;

    maxSum.set(Math.max(maxSum.get(), leftSum + rightSum + root.data));

    return root.data + Math.max(leftSum, rightSum);
  }
}
