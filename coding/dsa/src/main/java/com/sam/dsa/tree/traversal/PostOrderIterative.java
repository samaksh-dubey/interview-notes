package com.sam.dsa.tree.traversal;

import com.sam.dsa.tree.node.Node;
import java.util.Stack;

/**
 * post order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
public class PostOrderIterative implements ITraversal {

  public void traverse(Node root) {
    if (root != null) {
      Stack<Node> stack = new Stack<>();
      stack.push(root);

      Stack<Node> postOrderedStack = new Stack<>();

      while (!stack.isEmpty()) {
        Node temp = stack.pop();
        postOrderedStack.push(temp);

        if (temp.getLeft() != null) {
          stack.push(temp.getLeft());
        }

        if (temp.getRight() != null) {
          stack.push(temp.getRight());
        }
      }

      while (!postOrderedStack.isEmpty()) {
        Node temp = postOrderedStack.pop();
        System.out.println(temp.getData());
      }
    }
  }
}
