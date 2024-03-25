package c1_1000.c695_岛屿的最大面积;

public class Main {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int ans = 1;
        if (i + 1 < grid.length)
            ans += dfs(grid, i + 1, j);
        if (i - 1 >= 0)
            ans += dfs(grid, i - 1, j);
        if (j + 1 < grid[0].length)
            ans += dfs(grid, i, j + 1);
        if (j - 1 >= 0)
            ans += dfs(grid, i, j - 1);
        return ans;
    }
}
