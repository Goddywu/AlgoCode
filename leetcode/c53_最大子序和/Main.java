package c53_最大子序和;

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
}
