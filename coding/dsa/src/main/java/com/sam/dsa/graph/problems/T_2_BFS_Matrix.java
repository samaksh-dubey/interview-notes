package com.sam.dsa.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class T_2_BFS_Matrix {

    static void bfs(int[][] graph, boolean[] visited, int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        while (!queue.isEmpty()) {
            u = queue.poll();
            if(visited[u])
                continue;

            System.out.println(u + " ");
            visited[u] = true;

            for (int v = 0; v < graph.length; v++) {
                if (!visited[v] && graph[u][v] == 1)
                    queue.add(v);
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
            bfs(graph, visited, u);
        }
    }
}
