package com.sam.dsa.ds._8_graph.base;

import lombok.Getter;

public class Edge {
  @Getter private final int source, destination, weight;

  private Edge(int source, int destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }

  public static Edge of(int source, int destination) {
    return new Edge(source, destination, 0);
  }

  public static Edge of(int source, int destination, int weight) {
    return new Edge(source, destination, weight);
  }

  @Override
  public String toString() {
    return "(" + source + ", " + destination + ")";
  }
}
