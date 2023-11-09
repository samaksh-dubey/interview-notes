package com.sam.ds.algo.practise.graph.problems;

import com.sam.ds.algo.practise.graph.base.Edge;
import com.sam.ds.algo.practise.graph.base.Graph;
import com.sam.ds.algo.practise.graph.base.Vertex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P_1_ShortestPath_Dijkstra {

    public static void shortestPath(Graph graph, int source, int n) {

        class DijkstraVertex extends Vertex {
            final int weight;

            protected DijkstraVertex(int v, int weight) {
                super(v);
                this.weight = weight;
            }
        }

        int[] dist = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(done, Boolean.FALSE);

        Queue<DijkstraVertex> queue = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        dist[0] = 0;
        done[0] = true;
        queue.add(new DijkstraVertex(0, 0));

        int[] prev = new int[n];
        prev[0] = -1;

        while(!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            int u = vertex.v;

            for(Edge edge: graph.adjList.get(u)) {
                if (!done[edge.dest] && dist[edge.dest] > dist[u] + edge.weight) {
                    dist[edge.dest] = dist[u] + edge.weight;
                    queue.add(new DijkstraVertex(edge.dest, dist[u] + edge.weight));
                    prev[edge.dest] = u;
                }
            }
            done[u] = true;
        }
    }
}
