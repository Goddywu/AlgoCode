package c746_使用最小花费爬楼梯;

public class Main {
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length <= 0) return 0;
    int prev = 0;
    int next = 0;
    for (int i = 2; i <= cost.length; i++) {
      int tmp = next;
      next = Math.min(prev + cost[i - 2], next + cost[i - 1]);
      prev = tmp;
    }
    return next;
  }
}
