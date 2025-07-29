package com.sam.dsa._7_graph.dfs;

import com.sam.dsa._7_graph.base.Graph;

public class _2_ArrivalDepartureTime {

  public static void arrivalDepartureTime(Graph graph) {
    int[] arrival = new int[graph.n];
    int[] departure = new int[graph.n];
    boolean[] visited = new boolean[graph.n];

    int time = -1;

    for (int i = 0; i < graph.n; i++) {
      if (!visited[i]) {
        time = dfs(graph, i, visited, time, arrival, departure);
      }
    }
  }

  private static int dfs(Graph graph, int vertex, boolean[] visited, int time, int[] arrival, int[] departure) {
    if (visited[vertex])
      return time;

    arrival[vertex] = ++time;
    visited[vertex] = true;

    for (Integer destination: graph.adjList.get(vertex)) {
      if (!visited[destination]) {
        time = dfs(graph, destination, visited, time, arrival, departure);
      }
    }

    departure[vertex] = ++time;
    return time;
  }

}
