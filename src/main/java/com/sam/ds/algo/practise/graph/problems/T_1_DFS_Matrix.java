package com.sam.ds.algo.practise.graph.problems;

import java.util.Stack;

public class T_1_DFS_Matrix {

    static void dfs(int[][] graph, boolean[] visited, int u) {
        Stack<Integer> stack = new Stack<>();
        stack.add(u);
        while (!stack.isEmpty()) {
            u = stack.pop();
            if(visited[u])
                continue;

            System.out.println(u + " ");
            visited[u] = true;

            for (int v = graph.length - 1; v >= 0; v--) {
                if (!visited[v] && graph[u][v] == 1)
                    stack.add(v);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}
        };

        boolean[] visited = new boolean[graph.length];

        for (int u = 0; u < graph.length; u++) {
            dfs(graph, visited, u);
        }
    }
}
