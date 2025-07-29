package com.sam.dsa.ds._8_graph.topological;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.Arrays;

public class _1_ViaDepartureTime {

  public static int[] topologicalSort(Graph graph) {
    boolean[] visited = new boolean[graph.n];
    int[] departureToIndex = new int[2 * graph.n];
    Arrays.fill(departureToIndex, -1);

    int time = -1;

    for (int src = 0; src < graph.n; src++) {
      if (!visited[src]) time = dfs(graph, src, visited, departureToIndex, time);
    }

    int[] sorted = new int[graph.n];
    int sortedIndex = 0;
    for (int i = 2 * graph.n - 1; i >= 0; i--) {
      if (departureToIndex[i] != -1) sorted[sortedIndex++] = departureToIndex[i];
    }

    return sorted;
  }

  private static int dfs(
      Graph graph, int src, boolean[] visited, int[] departureToIndex, int time) {
    if (visited[src]) return time;

    time = time + 1;
    visited[src] = true;

    for (Integer destination : graph.adjList.get(src)) {
      if (!visited[destination]) time = dfs(graph, destination, visited, departureToIndex, time);
    }

    departureToIndex[++time] = src;
    return time;
  }
}
