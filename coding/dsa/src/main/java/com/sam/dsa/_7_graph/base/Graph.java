package com.sam.dsa._7_graph.base;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  public int n;
  public List<List<Integer>> adjList = null;

  Graph(List<Edge> edges, int n) {
    this.n = n;

    adjList = new ArrayList<>();

    for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

    for (Edge edge : edges) {
      int src = edge.source;
      int destination = edge.destination;

      adjList.get(src).add(destination);
      adjList.get(destination).add(src);
    }
  }
}
