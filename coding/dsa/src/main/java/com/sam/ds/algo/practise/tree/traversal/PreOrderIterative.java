package com.sam.ds.algo.practise.tree.traversal;

import com.sam.ds.algo.practise.tree.node.Node;

import java.util.Stack;

/**
 * pre order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * */
public class PreOrderIterative implements ITraversal {

    public void traverse(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                System.out.println(temp.getData());

                if (temp.getRight() != null) {
                    stack.push(temp.getRight());
                }

                if (temp.getLeft() != null) {
                    stack.push(temp.getLeft());
                }
            }
        }
    }
}
