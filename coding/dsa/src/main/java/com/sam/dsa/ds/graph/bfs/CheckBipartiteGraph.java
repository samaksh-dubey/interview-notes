package com.sam.dsa.ds.graph.bfs;

import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayDeque;
import java.util.Queue;

// https://www.techiedelight.com/bipartite-graph/
public class CheckBipartiteGraph {

  public boolean isBipartite(UndirectedGraph graph) {
    int V = graph.getV();
    int at = 0;
    boolean[] discovered = new boolean[V];

    int[] level = new int[V];
    level[at] = 0;

    Queue<Integer> q = new ArrayDeque<>();
    q.add(at);
    discovered[at] = true;

    while (!q.isEmpty()) {
      at = q.poll();

      for (Neighbour to : graph.neighbours(at)) {
        if (!discovered[to.getVertex()]) {
          discovered[to.getVertex()] = true;
          level[to.getVertex()] = level[at] + 1;
          q.add(to.getVertex());
        } else if (level[at] == level[to.getVertex()]) {
          return false;
        }
      }
    }

    return true;
  }
}
