package com.sam.dsa.ds._8_graph.bfs;

import com.sam.dsa.ds._8_graph.base.DirectedGraph;
import com.sam.dsa.ds._8_graph.base.Edge;
import com.sam.dsa.ds._8_graph.base.Neighbour;
import java.util.*;

public class SnakeLadder {

  public static int minMoves(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
    int n = 10 * 10;
    List<Edge> edges = new ArrayList<>();

    for (int index = 0; index < n; index++) {
      for (int roll = 1; roll <= 6 && index + roll < n; roll++) {
        int destination = index + roll;

        int ladder = ladders.getOrDefault(destination, 0);
        int snake = snakes.getOrDefault(destination, 0);

        if (ladder != 0 || snake != 0) destination = ladder + snake;

        edges.add(Edge.of(index, destination));
      }
    }

    DirectedGraph graph = new DirectedGraph(edges, n);
    return bfs(graph, 0, n - 1);
  }

  private static int bfs(DirectedGraph graph, int src, int target) {
    boolean[] visited = new boolean[graph.getV()];
    int move = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(src);
    visited[src] = true;

    outer:
    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        int at = queue.poll();

        if (at == target) break outer;

        for (Neighbour to : graph.neighbours(at)) {
          if (!visited[to.getVertex()]) {
            visited[to.getVertex()] = true;
            queue.add(to.getVertex());
          }
        }
      }

      move = move + 1;
    }

    return move;
  }
}
