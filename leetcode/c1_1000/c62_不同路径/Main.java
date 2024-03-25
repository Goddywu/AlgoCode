package c1_1000.c62_不同路径;

public class Main {

  /**
   * 动态规划
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  /**
   * 排列组合公式
   *  C_n^m = n! / m
   */
  public int uniquePaths2(int m, int n) {
    //todo
    return 0;
  }
}
