package c1_1000.c189_旋转数组;

public class Main {

    /**
     * 临时数组
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }

    /**
     * 三次翻转
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] a, int left, int right) {
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }
}
