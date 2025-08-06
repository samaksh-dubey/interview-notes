package com.sam.dsa.ds.graph.bfs;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Edge;
import com.sam.dsa.ds.graph.base.Neighbour;
import com.sam.dsa.ds.graph.base.UndirectedGraph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://www.techiedelight.com/construct-directed-graph-from-undirected-graph/
public class ConvertUndirectedToDirected {

  public DirectedGraph toDirected(UndirectedGraph graph, int end) {
    List<Edge> edges = bfs(graph, end);
    return new DirectedGraph(edges, graph.getV());
  }

  private List<Edge> bfs(UndirectedGraph graph, int end) {
    List<Edge> edges = new ArrayList<>();
    boolean[] visited = new boolean[graph.getV()];

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(end);
    visited[end] = true;

    while (!queue.isEmpty()) {
      int at = queue.poll();

      for (Neighbour to : graph.neighbours(at)) {
        if (!visited[to.getVertex()]) {
          visited[to.getVertex()] = true;
          edges.add(Edge.of(to.getVertex(), at));
          queue.add(to.getVertex());
        }
      }
    }

    return edges;
  }
}
