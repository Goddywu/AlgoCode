package c1_1000.c200_岛屿数量;

public class Main {

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visit = new boolean[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visit[i][j] && grid[i][j] == '1') {
          count++;
          dfs(grid, visit, i, j);
        }
        visit[i][j] = true;
      }
    }
    return count;
  }

  private void dfs(char[][] grid, boolean[][] visit, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
    if (visit[i][j] || grid[i][j] == '0') return;

    visit[i][j] = true;
    dfs(grid, visit, i - 1, j);
    dfs(grid, visit, i + 1, j);
    dfs(grid, visit, i, j - 1);
    dfs(grid, visit, i, j + 1);
  }
}
