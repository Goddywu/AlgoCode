package c1_1000.c518_零钱兑换;

// https://leetcode-cn.com/problems/coin-change-2/
public class Main {

  // Todo
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }
}
