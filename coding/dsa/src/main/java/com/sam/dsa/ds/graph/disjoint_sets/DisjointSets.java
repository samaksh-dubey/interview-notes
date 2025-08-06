package com.sam.dsa.ds.graph.disjoint_sets;

public class DisjointSets {
  int[] rank, parent;
  int n;

  public DisjointSets(int n) {
    rank = new int[n];
    parent = new int[n];
    this.n = n;
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int find(int i) {
    int root = parent[i];
    if (parent[root] != root) {
      return parent[i] = find(root);
    }

    return root;
  }

  public void union(int x, int y) {
    int xRoot = find(x), yRoot = find(y);

    if (xRoot == yRoot) return;

    if (rank[xRoot] < rank[yRoot]) {
      parent[xRoot] = yRoot;
    } else if (rank[yRoot] < rank[xRoot]) {
      parent[yRoot] = xRoot;
    } else {
      parent[yRoot] = xRoot;
      rank[xRoot] = rank[xRoot] + 1;
    }
  }
}
