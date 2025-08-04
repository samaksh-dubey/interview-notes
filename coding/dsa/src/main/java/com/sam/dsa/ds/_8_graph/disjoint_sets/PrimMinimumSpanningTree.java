package com.sam.dsa.ds._8_graph.disjoint_sets;

import com.sam.dsa.ds._8_graph.base.Edge;
import com.sam.dsa.ds._8_graph.base.Graph;
import com.sam.dsa.ds._8_graph.base.Neighbour;
import com.sam.dsa.ds._8_graph.base.UndirectedGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimMinimumSpanningTree {

  public void primMST(UndirectedGraph graph, int start) {
    PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
    boolean[] visited = new boolean[graph.getV()];

    minHeap.add(Edge.of(start, start, 0));

    while (!minHeap.isEmpty()) {
      Edge current = minHeap.poll();

      if (visited[current.getDestination()])
        continue;

      visited[current.getDestination()] = true;
      System.out.println("Edge: " + current.getSource() + " - " + current.getDestination() + " | Weight: " + current.getWeight());

      for (Neighbour neighbor : graph.neighbours(current.getSource())) {
        if (!visited[neighbor.getVertex()]) {
          minHeap.add(Edge.of(current.getSource(), neighbor.getVertex(), neighbor.getWeight()));
        }
      }
    }
  }
}
