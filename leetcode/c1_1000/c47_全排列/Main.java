package c1_1000.c47_全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visit = new boolean[nums.length];
    permuteUnique(ans, nums, visit, new ArrayList<>());
    return ans;
  }

  private static void permuteUnique(List<List<Integer>> ans, int[] nums,
      boolean[] visit, ArrayList<Integer> tmp) {
    if (tmp.size() == nums.length) {
      ans.add(new ArrayList<>(tmp));
      return;
    }
    for (int i = 0; i < visit.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) continue;
      if (!visit[i]) {
        visit[i] = true;
        tmp.add(nums[i]);
        permuteUnique(ans, nums, visit, tmp);
        visit[i] = false;
        tmp.remove(tmp.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    permuteUnique(new int[] {1, 1, 2});
  }
}
