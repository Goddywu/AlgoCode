package s122_买卖股票的最佳时机;

/**
 * @author Goddy <wuchuansheng@kanzhun.com> 2024-02-04
 */
public class Main {

    public static int m1(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(m1(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
