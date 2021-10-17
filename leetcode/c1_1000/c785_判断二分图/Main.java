package c1_1000.c785_判断二分图;

import java.util.*;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-05-04
 */
public class Main {

    // TODO: 修复下
    public static boolean isBipartite(int[][] graph) {
        Map<Integer, Boolean> dict = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0) {
                queue.offer(i);
                dict.put(i, true);
                break;
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            boolean flag = dict.get(index);

            for (int neighbor : graph[index]) {
                if (!dict.containsKey(neighbor)) {
                    dict.put(neighbor, !flag);
                    queue.offer(neighbor);
                } else {
                    if (dict.get(neighbor) == flag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph;

        graph = new int[][]{new int[]{1,2,3},new int[]{0,2},new int[]{0,1,3},new int[]{0,2}};
        System.out.println(isBipartite(graph));

        graph = new int[][]{new int[]{1,3},new int[]{0,2},new int[]{1,3},new int[]{0,2}};
        System.out.println(isBipartite(graph));

        graph = new int[][]{new int[]{1},new int[]{0,3},new int[]{3},new int[]{1,2}};
        // a: 0 3
        // b: 1 2
        System.out.println(isBipartite(graph));

    }
}
