package c739_每日温度;

import java.util.Stack;

public class Main {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];
    Stack<int[]> stack = new Stack<>(); // num, position
    for (int i = 0; i < temperatures.length; i++) {
      int n = temperatures[i];
      if (stack.isEmpty()) {
        stack.add(new int[]{n, i});
        continue;
      }
      while (!stack.isEmpty()) {
        int[] numPo = stack.peek();
        if (n <= numPo[0]) break;
        ans[numPo[1]] = i - numPo[1];
        stack.pop();
      }
      stack.add(new int[]{n, i});
    }
    while (!stack.isEmpty()) {
      int[] numPo = stack.pop();
      ans[numPo[1]] = 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
  }
}
