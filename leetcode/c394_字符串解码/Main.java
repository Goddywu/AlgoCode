package c394_字符串解码;

import java.util.Stack;

public class Main {

  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Integer> numStack = new Stack<>();
    Stack<StringBuilder> builderStack = new Stack<>();
    int num = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) num = num * 10 + c - '0';
      else if (c == '[') {
        numStack.add(num);
        builderStack.add(sb);
        num = 0;
        sb = new StringBuilder();
      } else if (Character.isLetter(c)) {
        sb.append(c);
      } else { // ]
        int times = numStack.pop();
        StringBuilder tmpSb = builderStack.pop();
        while (times-- > 0) tmpSb.append(sb);
        sb = tmpSb;
      }
    }
    return sb.toString();
  }
}
