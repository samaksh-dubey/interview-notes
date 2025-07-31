package com.sam.dsa.ds._8_graph.dfs;

import com.sam.dsa.ds._8_graph.base.Neighbour;
import com.sam.dsa.ds._8_graph.base.UndirectedGraph;
import java.util.List;
import java.util.Stack;

public class DFS {

  public static void dfs_recursive(UndirectedGraph graph, int at, boolean[] discovered) {
    discovered[at] = true;
    System.out.print(at + " ");

    for (Neighbour to : graph.neighbours(at)) {
      if (!discovered[to.getVertex()]) {
        dfs_recursive(graph, to.getVertex(), discovered);
      }
    }
  }

  public static void dfs_iterative(UndirectedGraph graph, int src, boolean[] discovered) {
    Stack<Integer> stack = new Stack<>();
    stack.push(src);

    while (!stack.empty()) {
      int at = stack.pop();

      if (discovered[at]) {
        continue;
      }

      discovered[at] = true;
      System.out.print(at + " ");

      List<Neighbour> adjList = graph.neighbours(at);
      for (int i = adjList.size() - 1; i >= 0; i--) {
        int to = adjList.get(i).getVertex();
        if (!discovered[to]) {
          stack.push(to);
        }
      }
    }
  }
}
