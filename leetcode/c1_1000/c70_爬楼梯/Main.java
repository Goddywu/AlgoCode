package c1_1000.c70_爬楼梯;

public class Main {

  public int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  public int climbStairs2(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int prev = 1;
    int next = 2;
    while (n-- > 2) {
      int tmp = next;
      next = prev + next;
      prev = tmp;
    }
    return next;
  }
}
