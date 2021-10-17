package c1001_2000.c1219_加热器;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-08
 * https://www.lintcode.com/problem/1219/?fromId=209&_from=collection
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

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }
}
