package com.sam.dsa.ds._8_graph.topological;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.ArrayDeque;
import java.util.Queue;

public class _2_KahnAlgorithm {

  public static int[] topologicalSort(Graph graph) {
    int[] indegree = new int[graph.n];

    for (int src = 0; src < graph.n; src++)
      for (Integer destination : graph.adjList.get(src)) indegree[destination]++;

    Queue<Integer> queue = new ArrayDeque<>();

    for (int src = 0; src < graph.n; src++) if (indegree[src] == 0) queue.offer(src);

    int[] sorted = new int[graph.n];
    int sortedIdx = 0;

    while (!queue.isEmpty()) {
      int src = queue.poll();

      for (Integer destination : graph.adjList.get(src)) {
        indegree[destination]--;
        if (indegree[destination] == 0) {
          queue.offer(destination);
        }
      }

      sorted[sortedIdx++] = src;
    }

    if (sortedIdx != graph.n) {
      System.out.println("Graph contains a cycle!");
      return new int[0];
    }

    return sorted;
  }
}
