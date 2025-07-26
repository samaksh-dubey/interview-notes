package com.sam.dsa._5_tree.traversal.dfs;

import com.sam.dsa._5_tree.node.TreeNode;
import java.util.Stack;

public class _1_DfsTraversal {

  public void preOrder(TreeNode root) {
    if (root != null) {
      System.out.println(root.data + "  ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.data + "  ");
      inOrder(root.right);
    }
  }

  public void postOrder(TreeNode root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.println(root.data + "  ");
    }
  }

  public void preOrder_iter(TreeNode root) {
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while (!stack.isEmpty()) {
        TreeNode temp = stack.pop();
        System.out.println(temp.data);

        if (temp.right != null) {
          stack.push(temp.right);
        }

        if (temp.left != null) {
          stack.push(temp.left);
        }
      }
    }
  }

  public void inOrder_iter(TreeNode root) {
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      TreeNode current = root;

      while (!stack.isEmpty() || current != null) {

        if (current != null) {
          stack.push(current);
          current = current.left;
        } else {
          current = stack.pop();
          System.out.println(current.data);
          current = current.right;
        }
      }
    }
  }

  public void postOrder_iter(TreeNode root) {
    if (root != null) {
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      Stack<TreeNode> postOrderedStack = new Stack<>();

      while (!stack.isEmpty()) {
        TreeNode temp = stack.pop();
        postOrderedStack.push(temp);

        if (temp.left != null) {
          stack.push(temp.left);
        }

        if (temp.right != null) {
          stack.push(temp.right);
        }
      }

      while (!postOrderedStack.isEmpty()) {
        TreeNode temp = postOrderedStack.pop();
        System.out.println(temp.data);
      }
    }
  }
}
