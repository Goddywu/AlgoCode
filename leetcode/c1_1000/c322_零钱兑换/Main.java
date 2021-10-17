package c1_1000.c322_零钱兑换;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-17
 */
public class Main {

    /**
     * 动态规划，太慢了。。
     */
    public static int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;

        for (int coin : coins) {
            if (coin < amount + 1) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i > coins[j] && dp[i - coins[j]] != null) {
                    dp[i] = dp[i] == null ? dp[i - coins [j]] + 1 : Math.min(dp[i], dp[i - coins [j]] + 1);
                }
            }
        }

        return dp[amount] == null ? -1 : dp[amount];
    }

    /**
     * 动态规划，leetcode答案
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(coinChange(new int[]{2}, 3)); // -1
        System.out.println(coinChange(new int[]{1}, 0)); // 0
        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27)); // 4
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249)); // 20
    }
}
