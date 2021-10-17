package c1_1000.c419_甲板上的战舰;

import java.util.Queue;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-06-13
 */
public class Main {

    /**
     * 找出右边和下边都没有的棋子代表一个战舰
     */
    public static int countBattleships(char[][] board) {
        int rowLen = board.length;
        if (rowLen == 0) {
            return 0;
        }
        int colLen = board[0].length;

        int count = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'X' && (i + 1 >= rowLen || board[i + 1][j] != 'X') && (j + 1 >= colLen || board[i][j + 1] != 'X')) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][]{
                {'X' , '.' , '.' , 'X'},
                {'.' , '.' , '.' , 'X'}
        }));

        System.out.println(countBattleships(new char[][]{
                {'.'}
        }));
    }
}
