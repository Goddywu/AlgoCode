package c16_最接近的三数之和;

import java.util.Arrays;

// https://leetcode-cn.com/problems/3sum-closest/
public class Main {

    // === 1. 暴力 ===

    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (ans == Integer.MAX_VALUE
                            || Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(ans - target)) {
                        ans = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return ans;
    }

    // === 2. 先排序，双指针 ===

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 100000;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
