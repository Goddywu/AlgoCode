package 典型题目.d_二分查找.c69_sqrtx;

// https://leetcode-cn.com/problems/sqrtx/
public class Main {

  /**
   * 二分法
   */
  public int mySqrt(int x) {
    return binarySearch(x, 0, x);
  }

  private int binarySearch(int x, int left, int right) {
    if (left >= right) return left;
    if (left == right - 1)
      return x / right >= right ? right : left;

    int half = (left + right) / 2;
    if (x / half == half) return half;
    else if (x / half > half) return binarySearch(x, half, right);
    else return binarySearch(x, left, half - 1);
  }

  /**
   * 牛顿迭代
   */
  public int mySqrt2(int x) {
    float x0 = x;
    float x1 = (x0 + x / x0) / 2;
    while (Math.abs(x0 - x1) >= 0.1) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2;
    }
    return (int) x1;
  }

  /**
   * 额外：牛顿迭代，求立方根
   */
  public int lifang(int num) {
    float x0 = num;
    float x1 = (2 * x0 + num / x0 / x0) / 3;
    while (Math.abs(x1 - x0) > 0.01) {
      x0 = x1;
      x1 = (2 * x0 + num / x0 / x0) / 3;
    }
    return (int) x1;
  }

  public static void main(String[] args) {
    System.out.println(new Main().mySqrt(8));
    System.out.println(new Main().mySqrt2(8));
    System.out.println("-----");
    System.out.println(new Main().lifang(8));
    System.out.println(new Main().lifang(28));
  }
}
