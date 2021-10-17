package 排序算法.c2_选择排序;

import java.util.Arrays;

public class Main {

    /**
     * 1. 在未排序的序列中，找到最小的放到最前面
     * 2. 重复len-1遍
     * 时间复杂度O(n^2)
     */
    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            // 找到最小值的下标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            // 交换位置
            if (minIdx != i) {
                int tmp = nums[minIdx];
                nums[minIdx] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                selectionSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
    }
}
