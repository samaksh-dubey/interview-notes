package com.sam.dsa.ds.graph.dfs;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;

public class ArrivalDepartureTime {

  public static void arrivalDepartureTime(DirectedGraph graph) {
    int[] arrival = new int[graph.getV()];
    int[] departure = new int[graph.getV()];
    boolean[] visited = new boolean[graph.getV()];

    int time = -1;

    for (int node = 0; node < graph.getV(); node++) {
      if (!visited[node]) {
        time = dfs(graph, node, visited, time, arrival, departure);
      }
    }
  }

  private static int dfs(
      DirectedGraph graph, int at, boolean[] visited, int time, int[] arrival, int[] departure) {

    if (visited[at]) return time;

    arrival[at] = ++time;
    visited[at] = true;

    for (Neighbour to : graph.neighbours(at)) {
      if (!visited[to.getVertex()])
        time = dfs(graph, to.getVertex(), visited, time, arrival, departure);
    }

    departure[at] = ++time;
    return time;
  }
}
