package c1_1000.c36_有效的数独;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-12
 */
public class Main {

    public static boolean isValidSudoku(char[][] board) {
        int[][] rowMatrix = new int[9][9];
        int[][] colMatrix = new int[9][9];
        int[][][] subBoardMatrix = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0' - 1;
                int sum = ++rowMatrix[i][num];
                sum += ++colMatrix[j][num];
                sum += ++subBoardMatrix[i / 3][j / 3][num];
                if (sum > 3) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('0' - '0');
        System.out.println('1' - '0');
        System.out.println('9' - '0');
    }
}
