package c1_1000.c198_打家劫舍;

public class Main {

  public int rob(int[] nums) {
    if (nums.length <= 1) return nums[0];
    int[] robs = new int[nums.length];
    robs[0] = nums[0];
    robs[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      robs[i] = Math.max(robs[i - 2] + nums[i], robs[i - 1]);
    }
    return robs[robs.length - 1];
  }

  public int rob2(int[] nums) {
    if (nums.length <= 1) return nums[0];
    int prev = nums[0];
    int next = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      int tmp = next;
      next = Math.max(prev + nums[i], next);
      prev = tmp;
    }
    return next;
  }
}
