package s70_爬梯子;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-02-20
 */
public class Main {

    private static int m1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(m1(2));
        System.out.println(m1(3));
        System.out.println(m1(4));
    }
}
