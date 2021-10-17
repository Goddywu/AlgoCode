package c1_1000.c26_删除有序数组的重复项;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-17
 */
public class Main {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        System.out.println("-- case1 --");
        int[] nums1 = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        System.out.println("-- case2 --");
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
