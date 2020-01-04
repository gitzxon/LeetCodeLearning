package stock.BestTimeToBuyAndSellStock.IV;

public class SolutionNew {

    public int maxProfit(int transactionCount, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (transactionCount >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }

        int rowCount = transactionCount + 1;
        int colCount = prices.length;
        int[][] dp = new int[rowCount][colCount];
        for (int i = 0; i < colCount; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < rowCount; i++) {
            dp[i][0] = 0;
        }
        for (int k = 1; k < rowCount; k++) {
            for (int i = 1; i < colCount; i++) {

                int a = dp[k][i - 1];
                int b = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++) {
                    int price = prices[i] - prices[j];
                    int pre = 0;
                    if (j != 0) {
                        pre = dp[k - 1] [j - 1];
                    }
                    b = Math.max(b, price + pre);
                }
                dp[k][i] = Math.max(a, b);
            }
        }

        return dp[rowCount - 1][colCount - 1];


    }

}
