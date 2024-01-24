package s350_两个数组的交集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-01-15
 * https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/001.html#_01%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90
 */
public class Main {

    public static List<Integer> method1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num1 : nums1) {
            map1.compute(num1, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return v + 1;
            });
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num2 : nums2) {
            map2.compute(num2, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return v + 1;
            });
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            Integer num = e.getKey();
            if (map2.containsKey(num)) {
                for (int k = Math.min(map2.get(num), map1.get(num)); k > 0; k--) {
                    result.add(num);
                }
            }
        }
        return result;
    }

    public static List<Integer> method2(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1 ++;
                p2 ++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("---- method1 ----");
        System.out.println(method1(new int[]{1, 1, 2, 2}, new int[]{2, 2}));
        System.out.println(method1(new int[]{4, 5, 9}, new int[]{4, 4, 8, 9, 9}));

        System.out.println("---- method2 ----");
        System.out.println(method2(new int[]{1, 1, 2, 2}, new int[]{2, 2}));
        System.out.println(method2(new int[]{4, 5, 9}, new int[]{4, 4, 8, 9, 9}));

    }
}
