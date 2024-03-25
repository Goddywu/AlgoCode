package c1_1000.c14_最长公共前缀;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-03-11
 */
public class Main {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int k = 0;
        outerLoop:
        while (true) {
            Character curChar = null;
            for (String str : strs) {
                if (k >= str.length()) {
                    k -= 1;
                    break outerLoop;
                }
                if (curChar == null) {
                    curChar = str.charAt(k);
                    continue;
                }
                if (curChar != str.charAt(k)) {
                    k -= 1;
                    break outerLoop;
                }
            }
            k++;
        }
        return strs[0].substring(0, Math.min(k + 1, strs[0].length()));
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("结果：" + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("结果：" + longestCommonPrefix(new String[]{"dog"}));
        System.out.println("结果：" + longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
