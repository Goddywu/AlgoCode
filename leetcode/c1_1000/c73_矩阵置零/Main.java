package c1_1000.c73_矩阵置零;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-12
 */
public class Main {

    public static void setZeroes(int[][] matrix) {
        boolean row1hasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row1hasZero = true;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }


        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (i == 0) {
                    if (row1hasZero) {
                        matrix[i][j] = 0;
                    }
                } else {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(m1);
        System.out.println(Arrays.deepToString(m1));

        int[][] m2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(m2);
        System.out.println(Arrays.deepToString(m2));

        int[][] m3 = new int[][]{
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };
        setZeroes(m3);
        System.out.println(Arrays.deepToString(m3));


        int[][] m4 = new int[][]{
                {-4, -2147483648, 6, -7, 0},
                {-8, 6, -8, -6, 0},
                {2147483647, 2, -9, -6, -10}
        };
        setZeroes(m4);
        System.out.println(Arrays.deepToString(m4));
    }
}
