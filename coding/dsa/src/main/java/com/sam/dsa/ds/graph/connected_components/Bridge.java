package com.sam.dsa.ds.graph.connected_components;

import com.sam.dsa.ds.graph.base.Edge;
import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridge {

  private final List<Edge> bridges;
  private final UndirectedGraph graph;
  private final int[] ids;
  private final int[] low_link;
  private int time;

  Bridge(UndirectedGraph graph) {
    this.bridges = new ArrayList<>();
    this.graph = graph;
    this.time = 0;
    this.ids = new int[graph.getV()];
    Arrays.fill(this.ids, -1);
    this.low_link = new int[graph.getV()];
  }

  public List<Edge> process() {
    for (int node = 0; node < graph.getV(); node++) {
      if (ids[node] == -1) dfs(node, -1);
    }

    return bridges;
  }

  private void dfs(int at, int parent) {
    ids[at] = low_link[at] = time++;

    for (Neighbour to : graph.neighbours(at)) {
      if (ids[to.getVertex()] == -1) {
        dfs(to.getVertex(), at);
        low_link[at] = Math.min(low_link[at], low_link[to.getVertex()]);

        if (low_link[to.getVertex()] > ids[at]) bridges.add(Edge.of(at, to.getVertex()));

      } else if (parent != to.getVertex()) {
        low_link[at] = Math.min(low_link[at], ids[to.getVertex()]);
      }
    }
  }
}
