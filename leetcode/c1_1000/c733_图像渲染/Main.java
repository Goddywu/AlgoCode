package c1_1000.c733_图像渲染;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/flood-fill/
public class Main {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;
        Queue<int[]> pos = new LinkedList<>();
        pos.add(new int[]{sr, sc});
        while (!pos.isEmpty()) {
            int[] po = pos.poll();
            int x = po[0];
            int y = po[1];
            image[x][y] = newColor;
            if (y - 1 >= 0 && image[x][y - 1] == oldColor)
                pos.add(new int[]{x, y - 1});
            if (y + 1 < image[0].length && image[x][y + 1] == oldColor)
                pos.add(new int[]{x, y + 1});
            if (x - 1 >=0 && image[x - 1][y] == oldColor)
                pos.add(new int[]{x - 1, y});
            if (x + 1 < image.length &&image[x + 1][y] == oldColor)
                pos.add(new int[]{x + 1, y});
        }
        return image;
    }
}
