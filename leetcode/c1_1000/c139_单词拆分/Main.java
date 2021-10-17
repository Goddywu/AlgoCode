package c1_1000.c139_单词拆分;

import java.util.Arrays;
import java.util.List;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-17
 */
public class Main {

    /**
     * 不行，会超时。需要改成动态规划
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private static boolean wordBreak(String s, List<String> wordDict, int sIndex) {
        if (sIndex >= s.length()) {
            return true;
        }

        for (String word : wordDict) {
            if (sIndex + word.length() - 1 > s.length() - 1) {
                continue;
            }
            if (word.equals(s.substring(sIndex, sIndex + word.length()))) {
                boolean ans = wordBreak(s, wordDict, sIndex + word.length());
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word: wordDict) {
                if (i >= word.length() && dp[i - word.length()]) {
                    dp[i] = dp[i] || word.equals(s.substring(i - word.length(), i));
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak2("leetcode", Arrays.asList("leet", "code"))); // ture
        System.out.println(wordBreak2("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))); // false
    }
}
