package com.sam.dsa.ds.graph.cycle;

import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCycleUndirected {

  private static class Node {
    int v, parent;

    Node(int v, int parent) {
      this.v = v;
      this.parent = parent;
    }
  }

  public static void hasCycle(UndirectedGraph graph, int src, int n) {
    // call either bfs or dfs
  }

  // run this for all unvisited nodes in the graph after the return from here
  private static boolean hasCycle_BFS(UndirectedGraph graph, int src, int n) {
    boolean[] discovered = new boolean[n];
    discovered[src] = true;

    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(src, -1));
    discovered[src] = true;

    while (!q.isEmpty()) {
      Node at = q.poll();

      for (Neighbour to : graph.neighbours(at.v)) {
        if (!discovered[to.getVertex()]) {
          discovered[to.getVertex()] = true;
          q.add(new Node(to.getVertex(), at.v));
        } else if (to.getVertex() != at.parent) {
          return true;
        }
      }
    }

    return false;
  }

  // run this for all unvisited nodes in the graph after the return from here
  private static boolean hasCycle_DFS(UndirectedGraph graph, boolean[] visited, Node at) {
    visited[at.v] = true;

    for (Neighbour to : graph.neighbours(at.v)) {
      if (!visited[at.v]) {
        if (hasCycle_DFS(graph, visited, new Node(to.getVertex(), at.v))) {
          return true;
        }
      } else if (to.getVertex() == at.parent) {
        return true;
      }
    }

    return false;
  }
}
