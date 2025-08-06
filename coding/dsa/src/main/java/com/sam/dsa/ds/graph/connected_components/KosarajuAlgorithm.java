package com.sam.dsa.ds.graph.connected_components;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Edge;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KosarajuAlgorithm {

  private final DirectedGraph originalGraph;
  private final boolean[] visited;
  private final List<Integer> order;

  public KosarajuAlgorithm(DirectedGraph originalGraph) {
    this.originalGraph = originalGraph;
    this.visited = new boolean[originalGraph.getV()];
    this.order = new ArrayList<>();
  }

  public List<List<Integer>> getSCComponents() {
    fillOrder();
    Collections.reverse(order);
    Arrays.fill(visited, false);
    DirectedGraph reverseGraph = getTranspose();

    List<List<Integer>> components = new ArrayList<>();
    for (int node : order) {
      if (!visited[node]) {
        List<Integer> component = new ArrayList<>();
        dfs(reverseGraph, node, component);
        components.add(component);
      }
    }

    return components;
  }

  private void fillOrder() {
    for (int node = 0; node < originalGraph.getV(); node++)
      if (!visited[node]) dfs(originalGraph, node, order);
  }

  private DirectedGraph getTranspose() {
    List<Edge> edges = new ArrayList<>();
    for (int at = 0; at < originalGraph.getV(); at++) {
      for (Neighbour to : originalGraph.neighbours(at)) {
        edges.add(Edge.of(to.getVertex(), at));
      }
    }
    return new DirectedGraph(edges, originalGraph.getV());
  }

  private void dfs(DirectedGraph graph, int at, List<Integer> comp) {
    visited[at] = true;
    for (Neighbour to : graph.neighbours(at))
      if (!visited[to.getVertex()]) dfs(graph, to.getVertex(), comp);
    comp.add(at);
  }
}
