package com.sam.dsa.ds._8_graph.topological;

import com.sam.dsa.ds._8_graph.base.DirectedGraph;
import com.sam.dsa.ds._8_graph.base.Neighbour;
import java.util.Arrays;

public class ViaDepartureTime {

  public static int[] topologicalSort(DirectedGraph graph) {
    boolean[] visited = new boolean[graph.getV()];
    int[] departureToIndex = new int[2 * graph.getV()];
    Arrays.fill(departureToIndex, -1);

    int time = -1;

    for (int src = 0; src < graph.getV(); src++) {
      if (!visited[src]) time = dfs(graph, src, visited, departureToIndex, time);
    }

    int[] sorted = new int[graph.getV()];
    int sortedIndex = 0;
    for (int i = 2 * graph.getV() - 1; i >= 0; i--) {
      if (departureToIndex[i] != -1) sorted[sortedIndex++] = departureToIndex[i];
    }

    return sorted;
  }

  private static int dfs(
      DirectedGraph graph, int at, boolean[] visited, int[] departureToIndex, int time) {
    if (visited[at]) return time;

    time = time + 1;
    visited[at] = true;

    for (Neighbour to : graph.neighbours(at)) {
      if (!visited[to.getVertex()])
        time = dfs(graph, to.getVertex(), visited, departureToIndex, time);
    }

    departureToIndex[++time] = at;
    return time;
  }
}
