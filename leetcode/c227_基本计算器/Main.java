package c227_基本计算器;

import java.util.Stack;

public class Main {

  public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    int sign = '+'; // 符号
    int num = 0; // 当前数值

    // 数值全放进stack
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        continue;
      } else if (Character.isDigit(c)) {
        num += num * 10 + c - '0';
      }
      if (i == s.length() - 1 || !Character.isDigit(c)) {
        // 符号
        if (sign == '+') {
          stack.add(num);
        } else if (sign == '-') {
          stack.add(-num);
        } else if (sign == '*') {
          stack.add(stack.pop() * num);
        } else if (sign == '/') {
          stack.add(stack.pop() / num);
        }
        sign = c;
        num = 0;
      }
    }
    // 聚合
    while (!stack.isEmpty()) {
      ans += stack.pop();
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(calculate("3/2"));
  }
}
