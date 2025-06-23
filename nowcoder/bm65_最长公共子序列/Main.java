/*
 * https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11
 */
public class Main {
  public String LCS (String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int len = dp[i][j] + 1;
                    dp[i + 1][j + 1] = len;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int i = s1.length();
        int j = s2.length();
        if (dp[i][j] == 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
