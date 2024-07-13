import java.util.LinkedList;
import java.util.Queue;

class Pair {
  int row;
  int col;

  Pair(int r, int c) {
    this.row = r;
    this.col = c;
  }
}

public class ShortestBridge {

  Queue<Pair> islandArea = new LinkedList<>();

  private void dfs(int[][] grid, int N, int i, int j) {
    if (i >= N || j >= N || i < 0 || j < 0 || grid[i][j] == 0 || grid[i][j] == 2)
      return;
    islandArea.add(new Pair(i, j));
    grid[i][j] = 2;
    dfs(grid, N, i + 1, j);
    dfs(grid, N, i, j + 1);
    dfs(grid, N, i - 1, j);
    dfs(grid, N, i, j - 1);
  }

  public int shortestBridge(int[][] grid) {
    int N = grid.length;

    outerloop: for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, N, i, j);
          break outerloop;
        }
      }
    }

    int distance = 0;
    boolean[][] visited = new boolean[N][N];
    while (!islandArea.isEmpty()) {
      for (int i = 0, M = islandArea.size(); i < M; i++) {
        Pair arr = islandArea.poll();
        int r = arr.row;
        int c = arr.col;
        visited[r][c] = true;

        if ((r + 1) < N && !visited[r + 1][c]) {
          if (grid[r + 1][c] == 1)
            return distance;
          islandArea.add(new Pair(r + 1, c));
        }

        if ((r - 1) >= 0 && !visited[r - 1][c]) {
          if (grid[r - 1][c] == 1)
            return distance;
          islandArea.add(new Pair(r - 1, c));
        }

        if ((c + 1) < N && !visited[r][c + 1]) {
          if (grid[r][c + 1] == 1)
            return distance;
          islandArea.add(new Pair(r, c + 1));
        }

        if ((c - 1) >= 0 && !visited[r][c - 1]) {
          if (grid[r][c - 1] == 1)
            return distance;
          islandArea.add(new Pair(r, c - 1));
        }
      }
      distance++;
    }

    return distance;
  }

  public static void main(String[] args) {
    ShortestBridge sb = new ShortestBridge();
    // int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, {
    // 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    // int[][] grid = {{0,1}, {1,0}};
    int[][] grid = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
    sb.shortestBridge(grid);
  }
}
