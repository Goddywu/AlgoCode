package c1_1000.c56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return new int[0][2];

    Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

    List<int[]> ans = new ArrayList<>();
    int[] curInts = intervals[0];
    int po = 1;
    while (po < intervals.length) {
      int[] nums = intervals[po];
      if (curInts[1] < nums[0]) {
        ans.add(curInts);
        curInts = nums;
      } else {
        curInts = new int[]{curInts[0], Math.max(nums[1], curInts[1])};
      }
      po++;
    }
    ans.add(curInts);
    return ans.toArray(new int[ans.size()][]);
  }
}
