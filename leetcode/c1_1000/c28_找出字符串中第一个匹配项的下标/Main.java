package c1_1000.c28_找出字符串中第一个匹配项的下标;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-18
 */
public class Main {

    /**
     * 暴力
     */
    public static int strStr(String haystack, String needle) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < haystack.length() && idx2 < needle.length()) {
            if (haystack.charAt(idx1) != needle.charAt(idx2)) {
                idx1 = idx1 - idx2 + 1;
                idx2 = 0;
            } else {
                idx2++;
                idx1++;
            }

            if (idx2 == needle.length()) {
                return idx1 - needle.length();
            }
        }
        return -1;
    }

    /**
     * kmp算法
     * https://blog.csdn.net/qq_43869106/article/details/128753527
     */
    public static int strStr2(String text, String pattern) {
        int[] table = buildPartialMatchTable2(pattern);
        int j = 0; // 模式串中的指针
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1; // 匹配成功，返回起始位置
            }
        }
        return -1; // 未找到匹配
    }

    /**
     * 自己写的，边界值有点难写
     * [a, a, b, a, a, f]
     * [0, 1, 0, 1, 2, 0]
     */
    private static int[] buildPartialMatchTable(String pattern) {
        int[] table = new int[pattern.length()];
        for (int i = 0; i < pattern.length(); i++) {
            int j = 0;
            while (j != i && j < (i + 1) / 2) {
                if (pattern.charAt(j) != pattern.charAt(i - j)) {
                    break;
                } else {
                    j++;
                }
            }
            table[i] = j;
        }
        return table;
    }

    /**
     * chatgpt给的，更好写
     * [a, a, b, a, a, f]
     * [0, 1, 0, 1, 2, 0]
     */
    private static int[] buildPartialMatchTable2(String pattern) {
        int[] partialMatchTable = new int[pattern.length()];
        int j = 0; // 前缀末尾
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = partialMatchTable[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            partialMatchTable[i] = j;
        }
        return partialMatchTable;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("aabaabaaf", "aabaaf")); // 3
        System.out.println(strStr2("sadbutsad", "sad")); // 0
        System.out.println(strStr2("leetcode", "leeto")); // -1
        System.out.println(strStr2("mississippi", "issip")); // 4
    }
}
