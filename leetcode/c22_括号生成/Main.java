package c22_括号生成;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    generateParenthesis(ans, "", n, n);
    return ans;
  }

  private static void generateParenthesis(List<String> ans, String str, int left, int right) {
    if (left == 0 && right == 0) {
      ans.add(str);
      return;
    } else if (left == 0) {
      while (right-- > 0) str += ")";
      ans.add(str);
      return;
    }
    if (left == right) {
      generateParenthesis(ans, str + "(", left - 1, right);
    } else {
      generateParenthesis(ans, str + "(", left - 1, right);
      generateParenthesis(ans, str + ")", left, right - 1);
    }
  }

  public static void main(String[] args) {
    generateParenthesis(3);
  }
}
