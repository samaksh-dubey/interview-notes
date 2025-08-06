package com.sam.dsa.ds.graph.topological;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.ArrayDeque;
import java.util.Queue;

public class KahnAlgorithm {

  public static int[] topologicalSort(DirectedGraph graph) {
    int[] indegree = new int[graph.getV()];

    for (int at = 0; at < graph.getV(); at++)
      for (Neighbour to : graph.neighbours(at)) indegree[to.getVertex()]++;

    Queue<Integer> queue = new ArrayDeque<>();

    for (int node = 0; node < graph.getV(); node++) if (indegree[node] == 0) queue.offer(node);

    int[] sorted = new int[graph.getV()];
    int sortedIdx = 0;

    while (!queue.isEmpty()) {
      int at = queue.poll();

      for (Neighbour to : graph.neighbours(at)) {
        indegree[to.getVertex()]--;
        if (indegree[to.getVertex()] == 0) {
          queue.offer(to.getVertex());
        }
      }

      sorted[sortedIdx++] = at;
    }

    if (sortedIdx != graph.getV()) {
      System.out.println("Graph contains a cycle!");
      return new int[0];
    }

    return sorted;
  }
}
