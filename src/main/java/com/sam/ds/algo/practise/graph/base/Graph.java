package com.sam.ds.algo.practise.graph.base;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public final int vN;
    public final List<List<Edge>> adjList;

    public Graph(List<Edge> edges, int n) {
        this.vN = n;
        this.adjList = new ArrayList<>();
        init();
        init(edges);

    }

    private void init() {
        for (int i = 0; i < vN; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    private void init(List<Edge> edges) {
        for (Edge edge: edges) {
            this.adjList.get(edge.source).add(edge);
        }
    }
}