package com.sam.dsa.ds.graph.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Neighbour {
  @Getter private final int vertex, weight;
}
