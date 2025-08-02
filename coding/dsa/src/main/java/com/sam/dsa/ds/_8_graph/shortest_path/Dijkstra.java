package com.sam.dsa.ds._8_graph.shortest_path;

import com.sam.dsa.ds._8_graph.base.DirectedGraph;
import com.sam.dsa.ds._8_graph.base.Neighbour;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Dijkstra {

  @AllArgsConstructor
  private static class Node {
    @Getter @Setter int vertex, distance;
  }

  public static List<Integer> shortestPath(DirectedGraph graph, int src, int target) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
    minHeap.add(new Node(src, 0));

    int[] distance = new int[graph.getV()];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[src] = 0;

    boolean[] finished = new boolean[graph.getV()];
    finished[src] = true;

    int[] parent = new int[graph.getV()];
    parent[src] = -1;

    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      int at = node.getVertex();

      for (Neighbour neighbour : graph.neighbours(at)) {
        int to = neighbour.getVertex();
        int weight = neighbour.getWeight();

        // relaxation step
        if (!finished[to] && (distance[at] + weight) < distance[to]) {
          distance[to] = distance[at] + weight;
          parent[to] = at;
          minHeap.add(new Node(to, distance[to]));
        }
      }

      finished[at] = true;
    }

    // build path
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
