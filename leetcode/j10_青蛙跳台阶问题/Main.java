package j10_青蛙跳台阶问题;

public class Main {
  public static int numWays(int n) {
    int n1 = 1;
    int n2 = 2;
    if (n == 1) return n1;
    if (n == 2) return n2;
    while (n-- > 2) {
      int tmp = n2;
      n2 = (n1 + n2) % 1000000007;
      n1 = tmp;
    }
    return n2;
  }
}
