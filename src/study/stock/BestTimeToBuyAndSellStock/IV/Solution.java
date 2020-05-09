package study.stock.BestTimeToBuyAndSellStock.IV;

class Solution {

    public int maxProfit(int transactionCount, int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        if (transactionCount >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }

        // dp
        int[] max = new int[transactionCount + 1];
        int[] maxSellAtLastDay = new int[transactionCount + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
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