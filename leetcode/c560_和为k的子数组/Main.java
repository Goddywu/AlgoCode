package c560_和为k的子数组;

import java.util.HashMap;

public class Main {

  /**
   * 暴力
   */
  public int subarraySum(int[] nums, int k) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) ans++;
      }
    }
    return ans;
  }

  /**
   * 前缀和+哈希表
   */
  public int subarraySum2(int[] nums, int k) {
    int ans = 0;
    int curSum = 0;
    HashMap<Integer, Integer> map = new HashMap<>(); // 数字和，出现次数
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      // curSum - (curSum - k)  = k
      if (map.containsKey(curSum - k)) {
        ans += map.get(curSum - k);
      }
      map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    }
    return ans;
  }
}
