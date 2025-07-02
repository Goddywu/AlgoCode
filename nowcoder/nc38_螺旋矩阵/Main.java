public class Main {

    /**
     * 缩圈
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int col = minCol; col <= maxCol; col++) {
                result.add(matrix[minRow][col]);
            }
            for (int row = minRow + 1; row <= maxRow; row++) {
                result.add(matrix[row][maxCol]);
            }
            for (int col = maxCol - 1; maxRow != minRow && col >= minCol; col--) {
                result.add(matrix[maxRow][col]);
            }
            for (int row = maxRow - 1; maxCol != minCol && row > minCol; row--) {
                result.add(matrix[row][minCol]);
            }
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        return result;
    }


    public static void main(String[] args) {


        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }
}
