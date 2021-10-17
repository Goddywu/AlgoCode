package c1_1000.c151_反转字符串中的单词;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-18
 */
public class Main {

    private static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!sb.isEmpty()) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (!sb.isEmpty()) {
            words.add(sb.toString());
            sb = new StringBuilder();
        }
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
