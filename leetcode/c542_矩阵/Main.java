package c542_矩阵;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                mat[x - 1][y] = mat[x][y] + 1;
                queue.offer(new int[]{x - 1, y});
            }
            if (x + 1 < m && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                mat[x + 1][y] = mat[x][y] + 1;
                queue.offer(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                mat[x][y - 1] = mat[x][y] + 1;
                queue.offer(new int[]{x, y - 1});
            }
            if (y + 1 < n && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                mat[x][y + 1] = mat[x][y] + 1;
                queue.offer(new int[]{x, y + 1});
            }
        }
        return mat;
    }
}
