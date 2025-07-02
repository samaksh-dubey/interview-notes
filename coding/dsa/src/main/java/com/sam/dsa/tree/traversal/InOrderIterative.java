package com.sam.dsa.tree.traversal;

import com.sam.dsa.tree.node.Node;

import java.util.Stack;

/**
 * In order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * */
public class InOrderIterative implements ITraversal {

    public void traverse(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Node current = root;

            while (!stack.isEmpty() || current != null) {

                while(current != null) {
                    stack.push(current.getLeft());
                    current = current.getLeft();
                }

                current = stack.pop();

                System.out.println(current.getData());

                current = current.getRight();
            }
        }
    }
}
