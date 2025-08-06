package com.sam.dsa.ds.graph.cycle;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CheckCycleDirected {

  public static boolean hasCycle(DirectedGraph graph) {
    boolean[] visited = new boolean[graph.getV()];
    Set<Integer> path = new HashSet<>();

    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i] && hasCycle_DFS(graph, visited, path, i)) return true;
    }

    return false;
  }

  // Use dfs with path building
  private static boolean hasCycle_DFS(
      DirectedGraph graph, boolean[] visited, Set<Integer> path, int at) {
    if (path.contains(at)) return true;

    visited[at] = true;
    path.add(at);

    for (Neighbour to : graph.neighbours(at)) {
      if (!visited[at] && hasCycle_DFS(graph, visited, path, to.getVertex())) return true;
    }

    path.remove(at);

    return false;
  }

  // Use Kahn's algorithm
  private static boolean hasCycle_KahnAlgorithm(DirectedGraph graph) {
    int[] indegree = new int[graph.getV()];

    for (int at = 0; at < graph.getV(); at++)
      for (Neighbour to : graph.neighbours(at)) indegree[to.getVertex()]++;

    Queue<Integer> queue = new ArrayDeque<>();
    for (int node = 0; node < graph.getV(); node++) if (indegree[node] == 0) queue.offer(node);

    int sortedIdx = 0;

    while (!queue.isEmpty()) {
      int at = queue.poll();

      for (Neighbour to : graph.neighbours(at)) {
        indegree[to.getVertex()]--;
        if (indegree[to.getVertex()] == 0) queue.offer(to.getVertex());
      }

      sortedIdx = sortedIdx + 1;
    }

    return sortedIdx != graph.getV();
  }
}
