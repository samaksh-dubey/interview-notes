package com.sam.dsa.ds._8_graph.bfs;

import com.sam.dsa.ds._8_graph.base.Neighbour;
import com.sam.dsa.ds._8_graph.base.UndirectedGraph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

  public List<Integer> bfs(UndirectedGraph graph, int src, boolean[] discovered) {
    List<Integer> bfsNodes = new ArrayList<>();

    Queue<Integer> q = new ArrayDeque<>();
    discovered[src] = true;
    q.add(src);

    while (!q.isEmpty()) {
      int at = q.poll();
      bfsNodes.add(at);

      for (Neighbour to : graph.neighbours(at)) {
        if (!discovered[to.getVertex()]) {
          discovered[to.getVertex()] = true;
          q.add(to.getVertex());
        }
      }
    }

    return bfsNodes;
  }
}
