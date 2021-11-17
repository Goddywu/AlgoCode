package c31_下一个排列;

public class Main {

  public static void nextPermutation(int[] nums) {
    // 找到第一个不是增序的
    int i = nums.length - 1;
    while (i > 0 && nums[i - 1] >= nums[i]) {
      i--;
    }
    if (i != 0) {
      int j = nums.length - 1;
      while (j >= i && nums[j] <= nums[i - 1]) {
        j--;
      }
      swap(nums, i - 1, j);
    }
    // 找后面第一个可以替换i的
    // i到末尾反转
    int j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    nextPermutation(new int[]{3,2,1});
  }
}
