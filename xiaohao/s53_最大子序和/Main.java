package s53_最大子序和;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-02-20
 */
public class Main {

    // 贪心算法
    public static int m1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }

    // 动态规划
    public static int m2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(m1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(m2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
