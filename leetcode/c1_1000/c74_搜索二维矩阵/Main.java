package c1_1000.c74_搜索二维矩阵;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-07-02
 */
public class Main {

    /**
     * 两次二分法查找
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom) {
            int mid = (top + bottom + 1) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }
        int left = 0;
        int right = matrix[bottom].length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (matrix[bottom][mid] == target) {
                return true;
            } else if (matrix[bottom][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return matrix[bottom][right] == target;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 3
        )); // true

        System.out.println(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 13
        )); // false

        System.out.println(searchMatrix(
                new int[][]{
                        {1}
                }, 1
        )); // true

        System.out.println(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 11
        )); // true
    }

}
