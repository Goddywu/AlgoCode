package c59_螺旋矩阵;

import java.util.Arrays;

public class Main {

  public static int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    int x = 0, y = 0;
    int count = 1;
    ans[x][y] = count++;
    while (count <= n * n) {
      // 往右
      while (y + 1 < n && ans[x][y + 1] == 0) {
        ans[x][++y] = count++;
      }
      // 往下
      while (x + 1 < n && ans[x + 1][y] == 0) {
        ans[++x][y] = count++;
      }
      // 往左
      while (y - 1 >= 0 && ans[x][y - 1] == 0) {
        ans[x][--y] = count++;
      }
      // 往上
      while (x - 1 >= 0 && ans[x - 1][y] == 0) {
        ans[--x][y] = count++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(generateMatrix(3)));
  }
}
