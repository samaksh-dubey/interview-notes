package com.sam.dsa.ds.graph.connected_components;

import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {

  private final List<Integer> articulationPoints;
  private final UndirectedGraph graph;
  private final int[] ids;
  private final int[] low_link;
  private int time;

  ArticulationPoint(UndirectedGraph graph) {
    this.articulationPoints = new ArrayList<>();
    this.graph = graph;
    this.ids = new int[graph.getV()];
    Arrays.fill(this.ids, -1);
    this.low_link = new int[graph.getV()];
    this.time = 0;
  }

  public List<Integer> process() {
    for (int node = 0; node < graph.getV(); node++) if (this.ids[node] == -1) dfs(node, -1);

    return articulationPoints;
  }

  private void dfs(int at, int parent) {
    ids[at] = low_link[at] = time++;
    int children = 0;

    for (Neighbour to : graph.neighbours(at)) {

      if (ids[to.getVertex()] == -1) {
        children = children + 1;
        dfs(to.getVertex(), at);
        low_link[at] = Math.min(low_link[at], low_link[to.getVertex()]);

        if (parent != -1 && low_link[to.getVertex()] >= ids[at]) {
          articulationPoints.add(at);
        }
      } else if (to.getVertex() != parent) {
        low_link[at] = Math.min(low_link[at], ids[to.getVertex()]);
      }
    }

    if (parent == -1 && children > 1) {
      articulationPoints.add(at);
    }
  }
}
