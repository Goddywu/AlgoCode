package c1_1000.c35_搜索插入位置;

public class Main {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int half = left + (right - left) / 2;
            if (nums[half] == target) return half;
            else if (nums[half] > target) right = half - 1;
            else left = half + 1;
        }
        return left;
    }
}
