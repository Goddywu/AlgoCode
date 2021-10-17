package s189_旋转数组;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-02-04
 */
public class Main {

    public static int[] m1(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newI = (i + k) % nums.length;
            ans[newI] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(m1(new int[]{1, 2, 3, 4, 5, 6, 7}, 1)));
        System.out.println(Arrays.toString(m1(new int[]{1, 2, 3, 4, 5, 6, 7}, 2)));
        System.out.println(Arrays.toString(m1(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
