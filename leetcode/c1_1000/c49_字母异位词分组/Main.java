package c1_1000.c49_字母异位词分组;

import java.util.*;

public class Main {

    // === 1. 傻办法 ===

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 1) return Arrays.asList(Arrays.asList(strs));

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            boolean match = false;
            for (String k : map.keySet()) {
                if (checkYi(k, str)) {
                    map.get(k).add(str);
                    match = true;
                }
            }
            if (!match) {
                map.put(str, new ArrayList<String>() {{add(str);}});
            }
        }
        return new ArrayList<>(map.values());
    }

    private static boolean checkYi(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] cs1 = s1.toCharArray();
        Arrays.sort(cs1);
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs2);
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) return false;
        }
        return true;
    }

    // === 2. 优化傻办法 ===

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String newStr = new String(cs);
            List<String> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(s);
            map.put(newStr, list);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {

    }
}
