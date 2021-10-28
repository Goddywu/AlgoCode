package c169_多数元素;

import java.util.Arrays;

public class Main {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
