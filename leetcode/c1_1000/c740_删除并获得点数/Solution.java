public class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }

        int[] dp = new int[max + 1];
        for (int i : nums) {
            dp[i] += i;
        }
        return rob(dp);
    }

    public static int rob(int[] nums) {
        int Len = nums.length;
        int[] dp = new int[Len];
        dp[0] = nums[0];
        if (Len == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < Len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[Len - 1];
    }
}
