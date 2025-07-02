public class Main {

    public static int[] diagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        boolean flag = false;
        for (int sum = 0; sum <= m + n - 2; sum++) {
            if (flag) {
                for (int i = 0; i <= sum && i < m; i++) {
                    if (sum - i < n) {
                        ans[idx++] = mat[i][sum - i];
                    }
                }
            } else {
                for (int i = 0; i <= sum && i < n; i++) {
                    if (sum - i < m) {
                        ans[idx++] = mat[sum - i][i];
                    }
                }
            }
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(diagonalOrder(new int[][]{
                {1,2,85},
                {19,129,119990}
        })));
        System.out.println(Arrays.toString(diagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
    }
}
