package c1_1000.c350_两个数组的交集2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-03-11
 */
public class Main {

    public static int[] intersect(int[] nums1, int[] nums2) {
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
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
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

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
