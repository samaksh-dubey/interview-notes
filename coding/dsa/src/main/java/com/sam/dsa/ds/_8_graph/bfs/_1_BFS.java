package com.sam.dsa.ds._8_graph.bfs;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.ArrayDeque;
import java.util.Queue;

public class _1_BFS {

  public static void bfs(Graph graph, int v, boolean[] discovered) {
    Queue<Integer> q = new ArrayDeque<>();
    discovered[v] = true;
    q.add(v);

    while (!q.isEmpty()) {
      v = q.poll();
      System.out.print(v + " ");

      for (int u : graph.adjList.get(v)) {
        if (!discovered[u]) {
          discovered[u] = true;
          q.add(u);
        }
      }
    }
  }
}
