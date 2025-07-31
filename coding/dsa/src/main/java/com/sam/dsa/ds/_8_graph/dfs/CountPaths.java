package com.sam.dsa.ds._8_graph.dfs;

import com.sam.dsa.ds._8_graph.base.Neighbour;
import com.sam.dsa.ds._8_graph.base.UndirectedGraph;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPaths {
  public static int countPaths(UndirectedGraph graph, int src, int target) {
    AtomicInteger count = new AtomicInteger(0);
    boolean[] visited = new boolean[graph.getV()];
    dfs(graph, visited, src, target, count);
    return count.get();
  }

  private static void dfs(
      UndirectedGraph graph, boolean[] visited, int at, int target, AtomicInteger count) {
    if (at == target) {
      count.incrementAndGet();
      return;
    }

    visited[at] = true;
    for (Neighbour to : graph.neighbours(at)) {
      if (!visited[to.getVertex()]) dfs(graph, visited, to.getVertex(), target, count);
    }
    visited[at] = false;
  }

  // https://www.geeksforgeeks.org/dsa/count-possible-paths-two-vertices/
  private static void topologicalSort() {}
}
