package com.sam.dsa.ds._8_graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import lombok.AllArgsConstructor;

public class ChessKnight {

  @AllArgsConstructor
  private static class Node {
    int x, y;
  }

  static int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
  static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

  public static int minMoves(int n, int startX, int startY, int targetX, int targetY) {
    boolean[][] visited = new boolean[n][n];

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(startX, startY));
    visited[startX][startY] = true;

    int moves = 0;

    outer:
    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        assert queue.peek() != null;
        int x = queue.peek().x;
        int y = queue.poll().y;

        if (x == targetX && y == targetY) break outer;

        for (int i = 0; i < 8; i++) {
          int toX = x + dx[i];
          int toY = y + dy[i];

          if (toX >= 0 && toX < n && toY >= 0 && toY < n && !visited[toX][toY]) {
            queue.add(new Node(toX, toY));
            visited[toX][toY] = true;
          }
        }
      }

      moves = moves + 1;
    }

    return moves;
  }
}
