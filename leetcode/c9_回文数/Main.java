package c9_回文数;

public class Main {
  public boolean isPalindrome(int x) {
    char[] chars = String.valueOf(x).toCharArray();
    for (int i = 0; i < chars.length / 2; i++) {
      if (chars[i] != chars[chars.length - 1 - i]) return false;
    }
    return true;
  }
}
