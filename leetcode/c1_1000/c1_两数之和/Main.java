package c1_1000.c1_两数之和;

import java.util.HashMap;

public class Main {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int left = target - nums[i];
      if (map.containsKey(left)) {
        return new int[]{map.get(left), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{};
  }
}
