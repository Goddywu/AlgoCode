package c704_二分查找;

public class Main {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int half = (left + right) / 2;
            if (nums[half] == target) {
                return half;
            } else if (nums[half] > target) {
                right = half - 1;
            } else {
                left = half + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5}, 2));
    }
}
