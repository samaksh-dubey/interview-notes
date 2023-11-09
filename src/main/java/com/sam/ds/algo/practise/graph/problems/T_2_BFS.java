package com.sam.ds.algo.practise.graph.problems;

import com.sam.ds.algo.practise.graph.base.Edge;
import com.sam.ds.algo.practise.graph.base.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T_2_BFS {

    static class Iterative {
        static void bfs(Graph graph) {
            if(graph == null || graph.vN == 0)
                return;

            final boolean[] visited = new boolean[graph.vN];
            for (int v = 0; v < graph.vN; v++) {
                if(!visited[v]) {
                    bfs(graph, v, visited);
                }
            }
        }

        static void bfs(Graph graph, int v, boolean[] visited) {
            final Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            while(!queue.isEmpty()) {
                Integer u = queue.poll();

                if(visited[u])
                    continue;

                System.out.print(u + " ");
                visited[u] = true;

                for(Edge edge: graph.adjList.get(u)) {
                    if(!visited[edge.dest])
                        queue.add(edge.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2),
                new Edge(1, 3),
                new Edge(1, 4),
                new Edge(2, 5),
                new Edge(2, 6),
                new Edge(5, 9),
                new Edge(5, 10),
                new Edge(4, 7),
                new Edge(4, 8),
                new Edge(7, 11),
                new Edge(7, 12)
        );

        Graph graph = new Graph(edges, 15);

        Iterative.bfs(graph);
    }
}
