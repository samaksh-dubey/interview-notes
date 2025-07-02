package com.sam.dsa.tree.view;

import com.sam.dsa.tree.node.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 * */
public class TopView {

    static class ViewNode {
        Node node;
        int horizontalDistance;

        ViewNode(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public void view(Node root) {
        if (root != null) {
            Map<Integer, ViewNode> hdToNodeMap = new TreeMap<>();
            Queue<ViewNode> queue = new LinkedList<>();

            queue.add(new ViewNode(root, 0));

            while(!queue.isEmpty()) {
                ViewNode current = queue.poll();
                if (!hdToNodeMap.containsKey(current.horizontalDistance)) {
                    hdToNodeMap.put(current.horizontalDistance, current);
                }

                if (current.node.getLeft() != null) {
                    queue.add(new ViewNode(current.node.getLeft(), current.horizontalDistance - 1));
                }

                if (current.node.getRight() != null) {
                    queue.add(new ViewNode(current.node.getRight(), current.horizontalDistance + 1));
                }
            }

            hdToNodeMap.forEach((key, value) -> {
                System.out.print(value);
            });
        }
    }
}
