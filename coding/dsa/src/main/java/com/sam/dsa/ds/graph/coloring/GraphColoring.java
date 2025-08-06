package com.sam.dsa.ds.graph.coloring;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GraphColoring {

  public static Map<Integer, Integer> colorGraph(DirectedGraph graph, int n) {
    Map<Integer, Integer> result = new HashMap<>();

    for (int u = 0; u < n; u++) {
      Set<Integer> assigned = new TreeSet<>();

      for (Neighbour neighbour : graph.neighbours(u)) {
        if (result.containsKey(neighbour.getVertex())) {
          assigned.add(result.get(neighbour.getVertex()));
        }
      }

      int color = 1;
      for (Integer c : assigned) {
        if (color != c) break;
        color++;
      }

      result.put(u, color);
    }

    return result;
  }
}
