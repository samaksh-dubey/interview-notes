package com.sam.dsa.tree.traversal;

import com.sam.dsa.tree.node.Node;

/**
 * In order traversal of a tree
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * */
public class InOrderRecursive implements ITraversal {

    public void traverse(Node root) {
        if (root != null) {
            traverse(root.getLeft());
            System.out.println(root.getData() + "  ");
            traverse(root.getRight());
        }
    }
}
