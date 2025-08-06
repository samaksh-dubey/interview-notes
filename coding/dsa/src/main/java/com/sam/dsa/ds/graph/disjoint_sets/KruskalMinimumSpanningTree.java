package com.sam.dsa.ds.graph.disjoint_sets;

import com.sam.dsa.ds.graph.base.Edge;
import java.util.Arrays;
import java.util.Comparator;

public class KruskalMinimumSpanningTree {

  public static int kruskalMST(int V, Edge[] edges) {

    Arrays.sort(edges, Comparator.comparingInt(Edge::getWeight));

    DisjointSets dsu = new DisjointSets(V);
    int cost = 0, count = 0;

    for (Edge e : edges) {
      int source = e.getSource(), destination = e.getDestination(), weight = e.getWeight();

      if (dsu.find(source) != dsu.find(destination)) {
        dsu.union(source, destination);
        cost += weight;
        if (++count == V - 1) break;
      }
    }
    return cost;
  }
}
