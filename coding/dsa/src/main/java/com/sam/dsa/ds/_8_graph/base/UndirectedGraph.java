package com.sam.dsa.ds._8_graph.base;

import java.util.List;

public class UndirectedGraph extends Graph {
  public UndirectedGraph(List<Edge> edges, int V) {
    super(V, edges);
  }

  @Override
  protected void populateAdjacencyList(List<Edge> edges) {
    for (Edge edge : edges) {
      neighbours.get(edge.getSource()).add(new Neighbour(edge.getDestination(), edge.getWeight()));
      neighbours.get(edge.getDestination()).add(new Neighbour(edge.getSource(), edge.getWeight()));
    }
  }
}
