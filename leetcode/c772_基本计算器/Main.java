package c772_基本计算器;

import java.util.Stack;

public class Main {

  // FIXME:

  public static int calculate(String s) {
    return calculate(s, 0)[1]; // skipIdx, ans
  }

  public static int[] calculate(String s, int start) {
    int[] ans = new int[2]; // skipIdx, ans
    char sign = '+';
    int num = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = start; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      }
      if (c == '(') {
        int[] tmpAns = calculate(s, i + 1);
        i = tmpAns[0];
        num = tmpAns[1];
      }
      if (i == s.length() - 1 || !Character.isDigit(c) && c != '(') {
        if (sign == '+') stack.add(num);
        else if (sign == '-') stack.add(-num);
        else if (sign == '*') stack.add(stack.pop() * num);
        else if (sign == '/') stack.add(stack.pop() / num);

        if (c == ')') {
          ans[0] = i;  // don't forget it will i++
          break;
        }

        sign = c;
        num = 0;
      }
    }
    while (!stack.isEmpty()) {
      ans[1] += stack.pop();
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); // 21
  }
}
