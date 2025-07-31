package com.sam.dsa.ds._8_graph.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

public abstract class Graph {
  @Getter protected final int V; // number of vertices
  protected final List<List<Neighbour>> neighbours; // adjacency list u -> [(v1, w1), (v2, w2)....]

  public Graph(int V, List<Edge> edges) {
    this.V = V;
    this.neighbours = Collections.nCopies(V, new ArrayList<>());
    populateAdjacencyList(edges);
  }

  // method to be called from constructor to populate adjacency list
  protected abstract void populateAdjacencyList(List<Edge> edges);

  public List<Neighbour> neighbours(int u) {
    return this.neighbours.get(u);
  }
}
