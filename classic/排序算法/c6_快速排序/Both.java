package 排序算法.c6_快速排序;

import java.util.Arrays;

public class Both {

    /**
     * 1. 找一个数字作为基准 pivot，希望小的数字放到它前面，大的放在它后面
     * 2. 一般以最左边为基准，左右双指针，不符合左小右大交换指针的值到相反位置
     * 3. 递归分别处理基准的左右两侧
     */
    public static int[] quickSort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    private static int[] quickSort(int[] nums, int start, int end) {
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
            quickSort(nums, start, L - 1);
            quickSort(nums, L + 1, end);
        }
        return nums;
    }

    /**
     * 更新简单写法
     */
    public static int[] simpleQuickSort(int[] nums) {
        simpleQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void simpleQuickSort(int[] nums, int left, int right) {
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
        simpleQuickSort(nums, left, l - 1);
        simpleQuickSort(nums, l + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                quickSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
        System.out.println(Arrays.toString(
                simpleQuickSort(new int[]{3, 2, 6, 4, 2, 1, 9, 3})));
        System.out.println(Arrays.toString(
                simpleQuickSort(new int[]{2, 3, 5, 4, 1, 6, 9, 8, 7})));
    }
}
