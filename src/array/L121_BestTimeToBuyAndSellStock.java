package array;

public class L121_BestTimeToBuyAndSellStock {
    /**
     * keep track of min profit
     * if cur price is greater, calculate cur profit
     * keep updating global max profit with every cur profit
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(prices[i - 1], buy);
            if (prices[i] > buy) {
                int curProfit = prices[i] - buy;
                maxProfit = Math.max(maxProfit, curProfit);
            }
        }
        return maxProfit;
    }
}
