package c1_1000.c289_生命游戏;

import java.util.Arrays;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-05-04
 */
public class Main {

    public static void gameOfLife(int[][] board) {
        // 复制一份新的
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        int maxRow = board.length;
        int maxCol = board[0].length;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int live = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        if ((row + i) >= 0 && (row + i) < maxRow && (col + j) >= 0 && (col + j) < maxCol && copy[row + i][col + j] == 1) {
                            live++;
                        }
                    }
                }

                if (copy[row][col] == 1 && (live < 2 || live > 3)) {
                    board[row][col] = 0;
                    continue;
                }

                if (copy[row][col] == 0 && live == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void gameOfLife2(int[][] board) {
        // 活->死 -1，死->活 2
        int maxRow = board.length;
        int maxCol = board[0].length;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                int live = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        if ((row + i) >= 0 && (row + i) < maxRow && (col + j) >= 0 && (col + j) < maxCol
                                && (board[row + i][col + j] == 1 || board[row + i][col + j] == -1)) {
                            live++;
                        }
                    }
                }
                if (board[row][col] == 1 && (live < 2 || live > 3)) {
                    board[row][col] = -1;
                    continue;
                }
                if (board[row][col] == 0 && live == 3) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if(board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr;

        arr = new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}};
        gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{new int[]{1, 1}, new int[]{1, 0}};
        gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));

        System.out.println("------------");

        arr = new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}};
        gameOfLife2(arr);
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{new int[]{1, 1}, new int[]{1, 0}};
        gameOfLife2(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
