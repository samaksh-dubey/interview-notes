package com.sam.dsa.ds._8_graph.dfs;

import com.sam.dsa.ds._8_graph.base.Graph;
import java.util.List;
import java.util.Stack;

public class _1_DFS {

  public static void dfs_recursive(Graph graph, int v, boolean[] discovered) {
    discovered[v] = true;
    System.out.print(v + " ");

    for (int u : graph.adjList.get(v)) {
      if (!discovered[u]) {
        dfs_recursive(graph, u, discovered);
      }
    }
  }

  public static void dfs_iterative(Graph graph, int v, boolean[] discovered) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);

    while (!stack.empty()) {
      v = stack.pop();

      if (discovered[v]) {
        continue;
      }

      discovered[v] = true;
      System.out.print(v + " ");

      List<Integer> adjList = graph.adjList.get(v);
      for (int i = adjList.size() - 1; i >= 0; i--) {
        int u = adjList.get(i);
        if (!discovered[u]) {
          stack.push(u);
        }
      }
    }
  }
}
