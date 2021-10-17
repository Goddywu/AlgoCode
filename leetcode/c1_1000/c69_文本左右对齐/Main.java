package c1_1000.c69_文本左右对齐;

import java.util.List;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-18
 */
public class Main {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        // fixme: 2024/6/20
        return null;
    }

    private static void printArray(List<String> stringList) {
        System.out.println("----------------");
        for (String str : stringList) {
            System.out.println(str);
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(fullJustify(new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"
        }, 16));

        printArray(fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20));
    }
}
