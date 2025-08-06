package com.sam.dsa.ds.graph.topological;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.Arrays;

public class ViaDepartureTime {

  public static int[] topologicalSort(DirectedGraph graph) {
    boolean[] visited = new boolean[graph.getV()];
    int[] departureToIndex = new int[graph.getV()];
    Arrays.fill(departureToIndex, -1);

    int time = -1;

    for (int src = 0; src < graph.getV(); src++) {
      if (!visited[src]) time = dfs(graph, src, visited, departureToIndex, time);
    }

    int[] sorted = new int[graph.getV()];
    int sortedIndex = 0;
    for (int i = graph.getV() - 1; i >= 0; i--) {
      sorted[sortedIndex++] = departureToIndex[i];
    }

    return sorted;
  }

  private static int dfs(
      DirectedGraph graph, int at, boolean[] visited, int[] departureToIndex, int time) {
    if (visited[at]) return time;

    visited[at] = true;

    for (Neighbour to : graph.neighbours(at)) {
      if (!visited[to.getVertex()])
        time = dfs(graph, to.getVertex(), visited, departureToIndex, time);
    }

    departureToIndex[++time] = at;
    return time;
  }
}
