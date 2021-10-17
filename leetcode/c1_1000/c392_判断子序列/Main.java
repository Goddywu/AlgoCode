package c1_1000.c392_判断子序列;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-07-01
 */
public class Main {

    public static boolean isSubsequence(String s, String t) {
        int x = 0;
        int y = 0;
        while (x < s.length() && y < t.length()) {
            if (s.charAt(x) == t.charAt(y)) {
                x++;
            }
            y++;
        }
        return x == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc"));
    }
}
