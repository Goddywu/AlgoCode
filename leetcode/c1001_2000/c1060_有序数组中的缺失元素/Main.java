package c1001_2000.c1060_有序数组中的缺失元素;

public class Main {

  public static int missingElement(int[] nums, int k) {
    int n = nums.length;
    if (k > missNum(nums, n - 1))
      return nums[n - 1] + k - missNum(nums, n - 1);
    int left = 0, right = n - 1;
    while (left < right) {
      int half = (left + right) / 2;
      if (missNum(nums, half) < k) left = half + 1;
      else right = half;
    }
    return nums[left - 1] + k - missNum(nums, left - 1);
  }

  private static int missNum(int[] nums, int idx) {
    return nums[idx] - nums[0] - idx;
  }

  /**
   * 暴力
   */
  public static int missingElement2(int[] nums, int k) {
    int base = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (k > nums[i] - base - 1) {
        k -= nums[i] - base - 1;
        base = nums[i];
      } else {
        return base + k;
      }
    }
    return nums[nums.length - 1] + k;
  }

  public static void main(String[] args) {
//    System.out.println(missingElement2(new int[]{4,7,9,10}, 3));
//    System.out.println(missingElement(new int[]{4,7,9,10}, 3));

    System.out.println(missingElement(new int[]{1,2,5,8,11,13,14,21,22,25}, 7));
  }
}
