package com.sam.dsa.ds._8_graph.shortest_path;

import com.sam.dsa.ds._8_graph.base.DirectedGraph;
import com.sam.dsa.ds._8_graph.base.Neighbour;
import com.sam.dsa.ds._8_graph.topological.ViaDepartureTime;
import java.util.Arrays;

public class SinglePassBellmanFord {

  public static int[] shortestDistance(DirectedGraph graph, int source) {
    int[] topologicalOrder = ViaDepartureTime.topologicalSort(graph);

    int[] distance = new int[graph.getV()];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[source] = 0;

    for (int i = graph.getV() - 1; i >= 0; i--) {
      int at = topologicalOrder[i];
      for (Neighbour neighbour : graph.neighbours(at)) {
        int to = neighbour.getVertex();
        int weight = neighbour.getWeight();

        if (distance[at] != Integer.MAX_VALUE && distance[at] + weight < distance[to]) {
          distance[to] = distance[at] + weight;
        }
      }
    }

    return distance;
  }
}
