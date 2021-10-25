package c3_无重复字符的最长子串;

import java.util.HashSet;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        HashSet<Character> cs = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cs.contains(c)) {
                // FIXME:
            }
        }
        return max;
    }

}
