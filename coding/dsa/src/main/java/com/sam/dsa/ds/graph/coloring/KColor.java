package com.sam.dsa.ds.graph.coloring;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;

public class KColor {
  private static String COLORS[] = {
    "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"
  };

  private static boolean isSafe(DirectedGraph graph, int[] color, int v, int c) {
    for (Neighbour neighbour : graph.neighbours(v)) {
      if (color[neighbour.getVertex()] == c) return false;
    }
    return true;
  }

  private static void kColorable(DirectedGraph graph, int[] color, int k, int v) {
    if (v == graph.getV()) {
      for (v = 0; v < graph.getV(); v++) {
        System.out.printf("%-8s", COLORS[color[v]]);
      }

      System.out.println();

      return;
    }

    for (int c = 1; c <= k; c++) {
      if (isSafe(graph, color, v, c)) {
        color[v] = c;
        kColorable(graph, color, k, v + 1);
        color[v] = 0;
      }
    }
  }

  public static void kColorable(DirectedGraph g, int k) {
    int[] color = new int[g.getV()];
    kColorable(g, color, k, 0);
  }
}
