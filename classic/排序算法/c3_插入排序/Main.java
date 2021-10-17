package 排序算法.c3_插入排序;

import java.util.Arrays;

public class Main {

    /**
     * 1. 遍历每个数组，向前找到自己该在的位置
     */
    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int cur = i;
            while (cur > 0 && nums[cur - 1] > nums[i]) {
                nums[cur] = nums[cur - 1];
                cur--;
            }
            nums[cur] = val;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                insertionSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
    }
}
