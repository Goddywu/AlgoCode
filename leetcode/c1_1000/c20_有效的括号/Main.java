package c1_1000.c20_有效的括号;

import java.util.Stack;

public class Main {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.add(c);
      } else {
        if (stack.isEmpty()) return false;
        if (c == ')') {
          if (stack.pop() != '(') return false;
        } else if (c == ']') {
          if (stack.pop() != '[') return false;
        } else if (c == '}') {
          if (stack.pop() != '{') return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
  }
}
