package com.sam.dsa.ds._8_graph.dfs;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.concurrent.atomic.AtomicInteger;

public class _3_CountPaths {
  public static int countPaths(Graph graph, int src, int target) {
    AtomicInteger count = new AtomicInteger(0);
    boolean[] visited = new boolean[graph.n];
    dfs(graph, visited, src, target, count);
    return count.get();
  }

  private static void dfs(
      Graph graph, boolean[] visited, int current, int target, AtomicInteger count) {
    if (current == target) {
      count.incrementAndGet();
      return;
    }

    visited[current] = true;
    for (Integer dest : graph.adjList.get(current)) {
      if (!visited[dest]) dfs(graph, visited, dest, target, count);
    }
    visited[current] = false;
  }
}
