package c567_字符串的排列;

import java.util.Arrays;

// https://leetcode-cn.com/problems/permutation-in-string/
public class Main {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i) - 'a']++;
            nums2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(nums1, nums2)) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            nums2[s2.charAt(i - s1.length()) - 'a']--;
            nums2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(nums1, nums2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
