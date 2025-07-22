public class Main {

    public static String solve(String s, String t) {
        if ("0".equals(s) || "0".equals(t)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int m = s.length();
        int n = t.length();

        int left = 0;
        for (int sum = m + n - 2; sum >= 0; sum--) {
            int i = Math.max(0, sum - n + 1);
            while (i <= m - 1 && sum - i >= 0) {
                left += (s.charAt(i) - '0') * (t.charAt(sum - i) - '0');
                i++;
            }
            sb.append(left % 10);
            left = left / 10;
        }
        return left != 0 ? left + sb.reverse().toString() : sb.reverse().toString();
    }

    public static void main(String[] args) {

        // 336703162779040874
        System.out.println(solve("733064366", "459309139"));
        System.out.println(solve("11", "99"));
        System.out.println(solve("1", "0"));
        System.out.println(solve("111", "0"));

    }

}
