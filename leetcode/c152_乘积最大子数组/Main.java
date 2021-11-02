package c152_乘积最大子数组;

public class Main {
  public static int maxProduct(int[] nums) {
    if (nums.length <= 0) return 0;
    int max = nums[0];
    int maxSum = nums[0], minSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int curMax = nums[i] >= 0 ? maxSum : minSum;
      int curMin = nums[i] >= 0 ? minSum : maxSum;
      maxSum = Math.max(curMax * nums[i], nums[i]);
      minSum = Math.min(curMin * nums[i], nums[i]);

      max = Math.max(max, maxSum);
    }
    return max;
  }
}
