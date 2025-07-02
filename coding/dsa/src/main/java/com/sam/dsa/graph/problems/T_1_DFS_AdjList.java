package com.sam.dsa.graph.problems;

import com.sam.dsa.graph.base.Edge;
import com.sam.dsa.graph.base.DirectedGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class T_1_DFS_AdjList {

    static class Recursive {
        static void dfs(DirectedGraph graph) {
            if(graph == null || graph.vN == 0)
                return;

            boolean[] visited = new boolean[graph.vN];

            for (int i = 0; i < graph.vN; i++)
                if(!visited[i])
                    dfs(graph, i, visited);
        }

        static void dfs(DirectedGraph graph, int v, boolean[] visited) {
            visited[v] = true;
            List<Edge> edges = graph.adjList.get(v);

            System.out.print(v + " ");

            for(Edge edge: edges)
                if(!visited[edge.dest])
                    dfs(graph, edge.dest, visited);
        }
    }

    static class Iterative {
        static void dfs(DirectedGraph graph) {
            if(graph == null || graph.vN == 0)
                return;

            boolean[] visited = new boolean[graph.vN];

            for (int i = 0; i < graph.vN; i++) {
                if(!visited[i]) {
                    dfs(graph, i, visited);
                }
            }
        }

        static void dfs(DirectedGraph graph, int u, boolean[] visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(u);

            while(!stack.isEmpty()) {
                Integer v = stack.pop();

                if(visited[v])
                    continue;

                visited[v] = true;
                System.out.print(v + " ");

                List<Edge> edges = graph.adjList.get(v);
                for (int i = edges.size(); i > 0; i--)
                    if (!visited[edges.get(i-1).dest])
                        stack.push(edges.get(i-1).dest);
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2),
                new Edge(1, 7),
                new Edge(1, 8),
                new Edge(2, 3),
                new Edge(2, 6),
                new Edge(3, 4),
                new Edge(3, 5),
                new Edge(8, 9),
                new Edge(8, 12),
                new Edge(9, 10),
                new Edge(9, 11)
        );

        DirectedGraph graph = new DirectedGraph(edges, 13);
        Recursive.dfs(graph);
        System.out.println();
        Iterative.dfs(graph);
    }
}
