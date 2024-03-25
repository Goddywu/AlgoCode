package c1_1000.c283_移动零;

public class Main {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[cur] = n;
                cur++;
            }
        }
        for (;cur < nums.length; cur++) {
            nums[cur] = 0;
        }
    }
}
