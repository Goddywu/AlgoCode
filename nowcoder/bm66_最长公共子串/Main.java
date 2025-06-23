/**
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac
 */
public class Main {
  
  public static String LCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;
        int end = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    int len = dp[i][j] + 1;
                    dp[i + 1][j + 1] = len;
                    if (len > maxLen) {
                        maxLen = len;
                        end = j;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str2.substring(end - maxLen + 1, end + 1);
    }

    public static void main(String[] args) {

        System.out.println(LCS("1AB2345CD", "12345EF")); // 2345

    }
}
