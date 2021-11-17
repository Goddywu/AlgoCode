package c121_买卖股票的最佳时机;

public class Main {

  public int maxProfit(int[] prices) {
    int best = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int price : prices) {
      max = Math.max(max, price);
      if (price < min) {
        best = Math.max(best, max - min);
        min = price;
        max = min;
      }
    }
    return Math.max(best, max - min);
  }
}
