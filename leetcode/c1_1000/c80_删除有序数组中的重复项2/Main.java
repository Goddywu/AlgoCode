package c1_1000.c80_删除有序数组中的重复项2;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-28
 */
public class Main {

    // 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int idx = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[idx - 1]) {
                nums[idx] = nums[i];
                idx++;
            } else if (nums[i] != nums[idx - 2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    /**
     * 大佬写法
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates2(nums1)); // 5, nums = [1,1,2,2,3]
        System.out.println(Arrays.toString(nums1));

        int[] num2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates2(num2)); // 7, nums = [0,0,1,1,2,3,3]
        System.out.println(Arrays.toString(num2));
    }
}
