package c2001_3000.c2575_找出字符串的可整除数组;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-03-07
 * https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/?envType=daily-question&envId=2024-03-07
 */
public class Main {
    public static int[] divisibilityArray(String word, int m) {
        long curNum = 0;
        char[] charArray = word.toCharArray();
        int[] ans = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            curNum = curNum * 10L + (charArray[i] - '0');
            if (curNum % m == 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            curNum = curNum % m;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divisibilityArray("998244353", 3)));
        System.out.println(Arrays.toString(divisibilityArray("1010", 10)));
        System.out.println(Arrays.toString(divisibilityArray("4868438856666666", 6)));
    }
}
