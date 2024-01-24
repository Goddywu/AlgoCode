package s14_最长公共前缀;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-01-22
 */
public class Main {

    public static String method1(String[] strArr) {
        if (strArr.length == 0) {
            return "";
        }
        int k = 0;
        outerLoop:
        while (true) {
            Character curChar = null;
            for (String str : strArr) {
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
        if (k <= 0) {
            return "";
        }
        return strArr[0].substring(0, Math.min(k + 1, strArr[0].length()));
    }

    public static void main(String[] args) {
        System.out.println("答案：" + method1(new String[]{"flower", "flow", "flight"}));
        System.out.println("答案：" + method1(new String[]{"dog", "racecar", "car"}));
        System.out.println("答案：" + method1(new String[]{"", "racecar", "car"}));
        System.out.println("答案：" + method1(new String[]{}));
        System.out.println("答案：" + method1(new String[]{"car"}));
    }
}
