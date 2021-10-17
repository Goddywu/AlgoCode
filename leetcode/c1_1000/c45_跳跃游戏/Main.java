package c1_1000.c45_跳跃游戏;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-09
 */
public class Main {

    public static int jump(int[] nums) {
        int maxDistance = 0;
        int step = 0;
        int bestEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == bestEnd) {
                step++;
                bestEnd = maxDistance;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4})); // 2
        System.out.println(jump(new int[]{2, 3, 0, 1, 4})); // 2
        System.out.println(jump(new int[]{5, 3, 0, 1, 4})); // 1
        System.out.println(jump(new int[]{9, 0, 0, 0, 0})); // 1
        System.out.println(jump(new int[]{1, 9, 0, 0, 0})); // 2
    }
}
