package c1_1000.c5_最长回文子串;

// https://leetcode-cn.com/problems/longest-palindromic-substring/
public class Main {

  /**
   * 方法一：暴力求解
   */
  public String longestPalindrome(String s) {
    if (s.length() < 2) return s;
    int maxLen = 1;
    int begin = 0;
    for (int i = 0; i < s.length() - maxLen; i++) {
      for (int j = i + maxLen; j < s.length(); j++) {
        if (isValidPalindrome(s, i, j)) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  private boolean isValidPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) return false;

      left++;
      right--;
    }
    return true;
  }

  /**
   * 方法二：中心扩散 fixme
   */
  public String longestPalindrome2(String s) {
    if (s.length() < 2) return s;
    int maxLen = 1, begin = 0;
    int len = s.length();
    for (int i = 0; i < s.length() - 1; i++) {

    }
    return null;
  }


  /**
   * 方法三：动态规划
   *
   * 状态转移方程：d[i][j] = (n[i] == n[j]) && (j-i<3 || dp[i+1][j-1])
   */
  public String longestPalindrome3(String s) {
    if (s.length() < 2) return s;
    int maxLen = 1, begin = 0;
    int len = s.length();
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) dp[i][i] = true;

    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (s.charAt(i) != s.charAt(j)) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  /**
   * 方法四：Manacher算法 TODO
   */
}
