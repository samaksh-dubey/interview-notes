package com.sam.dsa.ds._8_graph.bfs;

import com.sam.dsa.ds._8_graph.base.Edge;
import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.*;

public class _3_SnakeLadder {

  public static int minMoves(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
    int n = 10 * 10;
    List<Edge> edges = new ArrayList<>();

    for (int src = 0; src < n; src++) {
      for (int roll = 1; roll <= 6 && src + roll < n; roll++) {
        int dest = src + roll;

        int ladder = ladders.getOrDefault(dest, 0);
        int snake = snakes.getOrDefault(dest, 0);

        if (ladder != 0 || snake != 0) dest = ladder + snake;

        edges.add(new Edge(src, dest));
      }
    }

    Graph graph = new Graph(edges, n);
    return bfs(graph, 0, n - 1);
  }

  private static int bfs(Graph graph, int src, int target) {
    boolean[] visited = new boolean[graph.n];
    int move = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(src);

    outer:
    while (!queue.isEmpty()) {

      int size = queue.size();
      while (size-- > 0) {
        int node = queue.poll();
        visited[node] = true;

        if (node == target) break outer;

        for (Integer dest : graph.adjList.get(node)) {
          if (!visited[dest]) queue.add(dest);
        }
      }

      move = move + 1;
    }

    return move;
  }
}
