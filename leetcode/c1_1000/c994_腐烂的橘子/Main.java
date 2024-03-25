package c1_1000.c994_腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) return -1;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int maxMinutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] xy = queue.poll();
                int x = xy[0], y = xy[1];
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    if (grid[x - 1][y] == 1)
                        queue.offer(new int[]{x - 1, y});
                }
                if (x + 1 < m && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    if (grid[x + 1][y] == 1)
                        queue.offer(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    if (grid[x][y - 1] == 1)
                        queue.offer(new int[]{x, y - 1});
                }
                if (y + 1 < n && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    if (grid[x][y + 1] == 1)
                        queue.offer(new int[]{x, y + 1});
                }
            }
            if (!queue.isEmpty()) maxMinutes++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) return -1;
            }
        }
        return maxMinutes;
    }
}
