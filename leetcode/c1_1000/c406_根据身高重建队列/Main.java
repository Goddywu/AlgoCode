package c1_1000.c406_根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/queue-reconstruction-by-height/
public class Main {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            return p2[0] - p1[0];
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {

    }
}
