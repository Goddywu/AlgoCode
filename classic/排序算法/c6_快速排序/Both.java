package 排序算法.c6_快速排序;

import java.util.Arrays;

public class Both {

    /**
     * 1. 找一个数字作为基准 pivot，希望小的数字放到它前面，大的放在它后面
     * 2. 一般以最左边为基准，左右双指针，不符合左小右大交换指针的值到相反位置
     * 3. 递归分别处理基准的左右两侧
     */
    public static int[] kuaisu(int[] nums) {
        return kuaisu(nums, 0, nums.length - 1);
    }

    private static int[] kuaisu(int[]nums, int start, int end) {
        int L = start;
        int R = end;
        if (start < end) {
            int p = nums[start];
            while (L < R) {
                while (L < R && nums[R] >= p) {
                    R--;
                }
                if (L < R) {
                    nums[L] = nums[R];
                }
                while (L < R && nums[L] <= p) {
                    L++;
                }
                if (L < R) {
                    nums[R] = nums[L];
                } else {
                    nums[L] = p;
                }
            }
            kuaisu(nums, start, L - 1);
            kuaisu(nums, L + 1, end);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                kuaisu(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
    }
}
