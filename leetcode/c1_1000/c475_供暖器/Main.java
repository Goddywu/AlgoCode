package c1_1000.c475_供暖器;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-09
 */
public class Main {
    public static int findRadius(int[] houses, int[] heaters) {
        int maxRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            int minSubRadios = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                int abs = Math.abs(houses[i] - heaters[j]);
                minSubRadios = Math.min(minSubRadios, abs);
            }
            maxRadius = Math.max(minSubRadios, maxRadius);
        }
        return maxRadius;
    }

    // fixme: 2024/6/9 更优解


    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));
    }
}
