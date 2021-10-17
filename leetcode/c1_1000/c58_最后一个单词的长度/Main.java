package c1_1000.c58_最后一个单词的长度;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-07-01
 */
public class Main {

    /**
     * 正向找
     */
    public static int lengthOfLastWord(String s) {
        int lastLen = 0;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                curLen++;
            } else {
                if (curLen != 0) {
                    lastLen = curLen;
                    curLen =  0;
                }
            }
        }
        if (curLen != 0) {
            return curLen;
        }
        return lastLen;
    }

    /**
     * 反向找
     */
    public static int lengthOfLastWord2(String s) {
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        if (idx < 0) {
            return 0;
        }
        int num = 0;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("Hello World")); // 5
        System.out.println(lengthOfLastWord2("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord2("luffy is still joyboy")); // 6
    }
}
