package 排序算法.c1_冒泡排序;

import java.util.Arrays;

public class Main {

    /**
     * 1. 两两对比，如果顺序不对则交换位置
     * 2. 交换len-1遍
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                bubbleSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
    }
}
