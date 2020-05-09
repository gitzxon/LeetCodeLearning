package study.stock.BestTimeToBuyAndSellStock.III;

class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    private int maxProfit(int[] prices, int transactionCount) {
        int[] max = new int[transactionCount + 1];
        int[] maxSellAtLastDay = new int[transactionCount + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[ i -1];
            int tmp = max[0];
            for (int j = 1; j <= transactionCount; j++) {
                maxSellAtLastDay[j] = Math.max(maxSellAtLastDay[j], tmp) + diff;
                tmp = max[j];
                max[j] = Math.max(max[j], maxSellAtLastDay[j]);
            }
        }
        return max[transactionCount];
    }
}