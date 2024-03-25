package c1_1000.c46_全排列;

import java.util.ArrayList;
import java.util.List;

public class Main {

  /**
   * 回溯递归
   */
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visit = new boolean[nums.length];
    fill(ans, nums, new ArrayList<>(), visit);
    return ans;
  }

  private static void fill(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tmp, boolean[] visit) {
    if (tmp.size() == nums.length) {
      ans.add(new ArrayList<>(tmp));
      return;
    }
    for (int i = 0; i < visit.length; i++) {
      if (!visit[i]) {
        visit[i] = true;
        tmp.add(nums[i]);
        fill(ans, nums, tmp, visit);
        tmp.remove(tmp.size() - 1);
        visit[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    permute(new int[] {1, 2, 3});
  }
}
