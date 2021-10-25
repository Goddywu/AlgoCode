package c977_有序数组的平方;

import java.util.Arrays;

public class Main {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
