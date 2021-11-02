package c224_基本计算器;

import java.util.Stack;

public class Main {

  public static int calculate(String s) {
    int ans = 0; // 存储结果
    int sign = 1; // 存储符号
    int num = 0; // 存储当前数值
    Stack<Integer> stack = new Stack<>(); // 有括号时的计算
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      } else if (c == '+' || c == '-') {
        ans += sign * num;
        sign = c == '+' ? 1 : -1;
        num = 0;
      } else if (c == '(') {
        stack.add(ans);
        stack.add(sign);
        ans = 0;
        sign = 1;
      } else if (c == ')') {
        ans += sign * num;
        num = 0;
        ans *= stack.pop();
        ans += stack.pop();
      } else if (Character.isDigit(c)) {
        num = 10 * num + c - '0';
      } else {
        // never reach there...
      }
    }
    ans += sign * num;
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(calculate("1 + 1"));
  }
}
