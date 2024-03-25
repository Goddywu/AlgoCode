package c1_1000.c3_无重复字符的最长子串;

import java.util.HashSet;

public class Main {

  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    HashSet<Character> set = new HashSet<>();
    int slow = 0, quick = 0;
    while (quick < s.length()) {
      char c = s.charAt(quick);
      if (set.contains(c)) {
        set.remove(s.charAt(slow));
        slow++;
      } else {
        max = Math.max(max, quick - slow + 1);
        quick++;
        set.add(c);
      }
    }
    return max;
  }

}
