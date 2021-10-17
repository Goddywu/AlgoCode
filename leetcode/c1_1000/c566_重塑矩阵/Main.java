package c1_1000.c566_重塑矩阵;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-08
 */
public class Main {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        if (rowLen * colLen != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int ansRow = 0;
        int ansCol = 0;
        for (int matRow = 0; matRow < rowLen; matRow++) {
            for (int matCol = 0; matCol < colLen; matCol++) {
                ans[ansRow][ansCol++] = mat[matRow][matCol];
                if (ansCol >= c) {
                    ansRow++;
                    ansCol = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 2, 4)));
    }
}
