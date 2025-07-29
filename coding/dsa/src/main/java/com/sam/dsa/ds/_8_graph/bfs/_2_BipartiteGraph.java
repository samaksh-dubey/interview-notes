package com.sam.dsa.ds._8_graph.bfs;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.ArrayDeque;
import java.util.Queue;

// https://www.techiedelight.com/bipartite-graph/
public class _2_BipartiteGraph {

  public static boolean isBipartite(Graph graph) {
    int n = graph.n;
    int v = 0;
    boolean[] discovered = new boolean[n];

    int[] level = new int[n];

    discovered[v] = true;
    level[v] = 0;

    Queue<Integer> q = new ArrayDeque<>();
    q.add(v);

    while (!q.isEmpty()) {
      v = q.poll();

      for (int u : graph.adjList.get(v)) {
        if (!discovered[u]) {
          discovered[u] = true;
          level[u] = level[v] + 1;
          q.add(u);
        } else if (level[v] == level[u]) {
          return false;
        }
      }
    }

    return true;
  }
}
