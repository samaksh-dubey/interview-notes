package com.sam.dsa.ds._8_graph.cycle;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.ArrayDeque;
import java.util.Queue;

public class _2_AcyclicUndirectedConnected {

  private static class Node {
    int v, parent;

    public Node(int v, int parent) {
      this.v = v;
      this.parent = parent;
    }
  }

  public static boolean isAcyclicConnected(Graph graph) {
    boolean[] visited = new boolean[graph.n];
    if (hasCycle(graph, visited, 0)) return false;

    for (int i = 0; i < graph.n; i++) {
      if (!visited[i]) return false;
    }

    return true;
  }

  private static boolean hasCycle(Graph graph, boolean[] visited, int current) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(current, -1));
    visited[current] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (Integer dest : graph.adjList.get(node.v)) {
        if (!visited[node.v]) {
          visited[dest] = true;
          queue.add(new Node(dest, node.v));
        } else if (dest != node.parent) {
          return true;
        }
      }
    }

    return false;
  }
}
