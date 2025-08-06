package com.sam.dsa.ds.graph.cycle;

import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayDeque;
import java.util.Queue;

public class CheckAcyclicUndirectedConnected {

  private static class Node {
    int v, parent;

    public Node(int v, int parent) {
      this.v = v;
      this.parent = parent;
    }
  }

  public static boolean isAcyclicConnected(UndirectedGraph graph) {
    boolean[] visited = new boolean[graph.getV()];
    if (hasCycle(graph, visited, 0)) return false;

    for (int node = 0; node < graph.getV(); node++) {
      if (!visited[node]) return false;
    }

    return true;
  }

  // To check cycle via bfs in undirected graph
  private static boolean hasCycle(UndirectedGraph graph, boolean[] visited, int src) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(src, -1));
    visited[src] = true;

    while (!queue.isEmpty()) {
      Node at = queue.poll();

      for (Neighbour to : graph.neighbours(at.v)) {
        if (!visited[at.v]) {
          visited[to.getVertex()] = true;
          queue.add(new Node(to.getVertex(), at.v));
        } else if (to.getVertex() != at.parent) {
          return true;
        }
      }
    }

    return false;
  }
}
