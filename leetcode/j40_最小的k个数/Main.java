package j40_最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  public int[] getLeastNumbers(int[] arr, int k) {
    Arrays.sort(arr);
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = arr[i];
    }
    return ans;
  }

  /**
   * 堆
   */
  public int[] getLeastNumbers2(int[] arr, int k) {
    if (k == 0) return new int[k];
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < k; i++) {
      queue.offer(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (queue.peek() > arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = queue.poll();
    }
    return ans;
  }
}
