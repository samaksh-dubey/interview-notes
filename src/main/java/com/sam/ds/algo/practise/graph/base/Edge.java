package com.sam.ds.algo.practise.graph.base;

public class Edge {
    public int source, dest, weight;

    public Edge(int source, int dest) {
        this(source, dest, 0);
    }

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}