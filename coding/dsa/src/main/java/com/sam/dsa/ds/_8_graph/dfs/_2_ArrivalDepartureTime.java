package com.sam.dsa.ds._8_graph.dfs;

import com.sam.dsa.ds._8_graph.base.Graph;

public class _2_ArrivalDepartureTime {

  public static void arrivalDepartureTime(Graph graph) {
    int[] arrival = new int[graph.n];
    int[] departure = new int[graph.n];
    boolean[] visited = new boolean[graph.n];

    int time = -1;

    for (int src = 0; src < graph.n; src++) {
      if (!visited[src]) {
        time = dfs(graph, src, visited, time, arrival, departure);
      }
    }
  }

  private static int dfs(
      Graph graph, int src, boolean[] visited, int time, int[] arrival, int[] departure) {

    if (visited[src]) return time;

    arrival[src] = ++time;
    visited[src] = true;

    for (Integer destination : graph.adjList.get(src)) {
      if (!visited[destination]) {
        time = dfs(graph, destination, visited, time, arrival, departure);
      }
    }

    departure[src] = ++time;
    return time;
  }
}
