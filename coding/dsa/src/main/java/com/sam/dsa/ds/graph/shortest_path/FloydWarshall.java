package com.sam.dsa.ds.graph.shortest_path;

import com.sam.dsa.ds.graph.base.Graph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.Arrays;

public class FloydWarshall {

  public static int[][] shortestDistance(Graph graph) {
    int[][] distance = new int[graph.getV()][graph.getV()];

    for (int i = 0; i < graph.getV(); i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
      distance[i][i] = 0;
    }

    for (int at = 0; at < graph.getV(); at++) {
      for (Neighbour neighbour : graph.neighbours(at)) {
        int to = neighbour.getVertex();
        distance[at][to] = neighbour.getWeight();
      }
    }

    for (int intermediate = 0; intermediate < graph.getV(); intermediate++) {
      for (int at = 0; at < graph.getV(); at++) {
        for (int to = 0; to < graph.getV(); to++) {
          if (distance[at][intermediate] != Integer.MAX_VALUE
              && distance[intermediate][to] != Integer.MAX_VALUE)
            distance[at][to] =
                Math.min(distance[at][to], distance[at][intermediate] + distance[intermediate][to]);
        }

        if (distance[at][at] < 0) {
          System.out.println("Negative-weight cycle found!!");
          return new int[graph.getV()][graph.getV()];
        }
      }
    }

    return distance;
  }
}
