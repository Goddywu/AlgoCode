package c1_1000.c415_字符串相加;

public class Main {

  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int i = num1.length() - 1, j = num2.length() - 1;
    int base = 0;
    while (i >= 0 || j >= 0 || base != 0) {
      if (i >= 0)
          base += num1.charAt(i) - '0';
      if (j >= 0)
          base += num2.charAt(j) - '0';
      sb.append(base % 10);
      base /= 10;
      i--;
      j--;
    }
    return sb.reverse().toString();
  }
}
