package 典型题目.d_二分查找.c34_在排序数组中查找第一个和最后一个位置;

import java.util.Arrays;

public class Main {
  public static int[] searchRange(int[] nums, int target) {
    if (nums.length <= 0) return new int[]{-1, -1};
    return searchRange(nums, target, 0, nums.length - 1);
  }

  private static int[] searchRange(int[] nums, int target, int left, int right) {
    if (left >= right) {
      if (nums[left] == target) return new int[]{left, right};
      else return new int[]{-1, -1};
    }

    int half = (left + right) / 2;
    if (nums[half] > target) {
      return searchRange(nums, target, left, half - 1);
    } else if (nums[half] < target) {
      return searchRange(nums, target, half + 1, right);
    } else {  // 相等
      int newLeft, newRight;
      if (half > 0 && nums[half - 1] == target) {
        newLeft = searchRange(nums, target, left, half - 1)[0];
      } else {
        newLeft = half;
      }
      if (half < nums.length - 1 && nums[half + 1] == target) {
        newRight = searchRange(nums, target, half + 1, right)[1];
      } else {
        newRight = half;
      }
      return new int[]{newLeft, newRight};
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
  }
}
