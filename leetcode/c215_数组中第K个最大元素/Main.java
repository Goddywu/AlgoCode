package c215_数组中第K个最大元素;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  /**
   * 暴力
   *  时间复杂度 nlog(n)
   */
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  /**
   * 堆
   *  时间复杂度 nlog(k)
   */
  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
    for (int n : nums) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }
    return heap.poll();
  }

  /**
   * 快速选择(快排)
   *   时间复杂度 n, 最坏 n^2
   */
  public int findKthLargest3(int[] nums, int k) {
    // todo
    return -1;
  }
}
