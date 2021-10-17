package c1_1000.c125_验证回文串;

public class Main {

  public static boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) return false;
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
      if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    isPalindrome("0P");
  }
}
