package c1_1000.c53_最大子序和;

public class Main {

    // f(n) = max( f(n-1)+n, n ) 动态规划公式
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int n : nums) {
            cur = Math.max(cur + n, n);
            max = Math.max(max, cur);
        }
        return max;
    }


    // 贪心算法
    public static int maxSubArray1(int[] nums) {
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
    public static int maxSubArray2(int[] nums) {
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
}
