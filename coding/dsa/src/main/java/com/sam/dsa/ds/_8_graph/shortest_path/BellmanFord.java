package com.sam.dsa.ds._8_graph.shortest_path;

import com.sam.dsa.ds._8_graph.base.DirectedGraph;
import com.sam.dsa.ds._8_graph.base.Edge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

  public static List<Integer> shortestPath(DirectedGraph graph, int src, int target) {
    int[] distance = new int[graph.getV()];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[src] = 0;

    int[] parent = new int[graph.getV()];
    Arrays.fill(parent, -1);

    for (int i = 0; i < graph.getV() - 1; i++) {
      for (Edge edge : graph.getEdges()) {
        // relaxation step
        if (distance[edge.getSource()] != Integer.MAX_VALUE
            && distance[edge.getSource()] + edge.getWeight() < distance[edge.getDestination()]) {
          distance[edge.getDestination()] = distance[edge.getSource()] + edge.getWeight();
          parent[edge.getDestination()] = edge.getSource();
        }
      }
    }

    // relaxation step once more to check negative weight cycle
    for (Edge edge : graph.getEdges()) {
      if (distance[edge.getSource()] != Integer.MAX_VALUE
          && distance[edge.getSource()] + edge.getWeight() < distance[edge.getDestination()]) {
        System.out.println("Negative-weight cycle is found!!");
        return new ArrayList<>();
      }
    }

    if (distance[target] != Integer.MAX_VALUE) {
      List<Integer> route = new ArrayList<>();
      route.add(target);

      while (target != src) {
        target = parent[target];
        route.add(target);
      }

      return route.reversed();
    }

    return Collections.emptyList();
  }
}
