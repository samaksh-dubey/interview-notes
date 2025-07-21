package com.sam.dsa.graph.base;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph {

  public final int vN;
  public final List<List<Edge>> adjList;

  public UndirectedGraph(List<Edge> edges, int n) {
    this.vN = n;
    this.adjList = new ArrayList<>();
    init();
    init(edges);
  }

  private void init() {
    for (int i = 0; i < vN; i++) {
      this.adjList.add(new ArrayList<>());
    }
  }

  private void init(List<Edge> edges) {
    for (Edge edge : edges) {
      this.adjList.get(edge.source).add(edge);
      this.adjList.get(edge.dest).add(edge);
    }
  }
}
