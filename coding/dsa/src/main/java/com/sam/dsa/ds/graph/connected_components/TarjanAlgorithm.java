package com.sam.dsa.ds.graph.connected_components;

import com.sam.dsa.ds.graph.base.DirectedGraph;
import com.sam.dsa.ds.graph.base.Neighbour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
  List<List<Integer>> res;
  Stack<Integer> stack;
  boolean[] stackMember;
  int[] ids;
  int[] low_link;
  int time;
  DirectedGraph graph;

  public TarjanAlgorithm(DirectedGraph graph) {
    this.res = new ArrayList<>();
    this.stack = new Stack<>();
    this.stackMember = new boolean[graph.getV()];
    this.ids = new int[graph.getV()];
    Arrays.fill(ids, -1);
    this.low_link = new int[graph.getV()];
    this.time = 0;
    this.graph = graph;
  }

  public List<List<Integer>> stronglyConnected() {

    for (int node = 0; node < graph.getV(); node++) {
      if (ids[node] == -1) dfs(node);
    }

    return res;
  }

  public void dfs(int at) {
    ids[at] = low_link[at] = time;
    time = time + 1;
    stackMember[at] = true;
    stack.push(at);

    for (Neighbour to : graph.neighbours(at)) {
      if (ids[to.getVertex()] == -1) dfs(to.getVertex());
      if (stackMember[to.getVertex()])
        low_link[at] = Math.min(low_link[at], low_link[to.getVertex()]);
    }

    int w = -1;
    if (low_link[at] == ids[at]) {
      List<Integer> scc = new ArrayList<>();
      while (w != at) {
        w = stack.pop();
        scc.add(w);
        stackMember[w] = false;
      }
      res.add(scc);
    }
  }
}
