package com.sam.dsa.ds._8_graph.cycle;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.ArrayDeque;
import java.util.Queue;

public class _1_Undirected {

  private static class Node {
    int v, parent;

    Node(int v, int parent) {
      this.v = v;
      this.parent = parent;
    }
  }

  public static void hasCycle(Graph graph, int src, int n) {
    // call either bfs or dfs
  }

  // run this for all unvisited nodes in the graph after the return from here
  public static boolean hasCycle_BFS(Graph graph, int src, int n) {
    boolean[] discovered = new boolean[n];
    discovered[src] = true;

    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(src, -1));
    discovered[src] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();

      for (int u : graph.adjList.get(node.v)) {
        if (!discovered[u]) {
          discovered[u] = true;
          q.add(new Node(u, node.v));
        } else if (u != node.parent) {
          return true;
        }
      }
    }

    return false;
  }

  // run this for all unvisited nodes in the graph after the return from here
  private static boolean hasCycle_DFS(Graph graph, boolean[] visited, Node current) {
    visited[current.v] = true;

    for (Integer dest : graph.adjList.get(current.v)) {
      if (!visited[current.v]) {
        if (hasCycle_DFS(graph, visited, new Node(dest, current.v))) {
          return true;
        }
      } else if (dest == current.parent) {
        return true;
      }
    }

    return false;
  }
}
