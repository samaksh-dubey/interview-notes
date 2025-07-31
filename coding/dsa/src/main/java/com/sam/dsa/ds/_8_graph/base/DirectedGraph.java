package com.sam.dsa.ds._8_graph.base;

import java.util.List;

public class DirectedGraph extends Graph {
  public DirectedGraph(List<Edge> edges, int V) {
    super(V, edges);
  }

  @Override
  protected void populateAdjacencyList(List<Edge> edges) {
    for (Edge edge : edges) {
      neighbours.get(edge.getSource()).add(new Neighbour(edge.getDestination(), edge.getWeight()));
    }
  }
}
