package c1_1000.c27_移除元素;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-17
 */
public class Main {

    public static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (idx != i) {
                    nums[idx] = nums[i];
                }
                idx ++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println("--- case1 ---");
        int[] nums1 = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));

        System.out.println("--- case2 ---");
        int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2));

    }
}
