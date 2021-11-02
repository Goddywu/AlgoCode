package c912_排序数组;

import java.util.Arrays;

public class Main {

  public static int[] sortArray(int[] nums) {
    sortArray(nums, 0, nums.length - 1);
    return nums;
  }

  private static void sortArray(int[] nums, int left, int right) {
    if (left >= right) return;

    int l = left, r = right;
    int p = nums[left];
    while (l < r) {
      while (l < r && nums[r] >= p) {
        r--;
      }
      nums[l] = nums[r];
      while (l < r && nums[l] <= p) {
        l++;
      }
      nums[r] = nums[l];
    }
    nums[l] = p;
    sortArray(nums, left, l - 1);
    sortArray(nums, l + 1, right);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArray(new int[]{3})));
    System.out.println(Arrays.toString(sortArray(new int[]{3, 2, 2, 1})));
    System.out.println(Arrays.toString(sortArray(new int[]{3, 2, 6, 1, 4})));
  }
}
