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
            int backup = Integer.MIN_VALUE;
            for (int i = 1; i < colCount; i++) {

                int a = dp[k][i - 1];
                int b = Integer.MIN_VALUE;

                // 观察每次循环 j 的时候的计算的值，发现，如果把 dp[k - 1][i - 2] - prices[i - 1] 缓存下来，就可以减少一层循环。
                // i == 1 的 case 是为了兼容 dp[k - 1][i - 2]
                if (i == 1) {
                    backup = -prices[0];
                } else {
                    backup = Math.max(
                            backup,
                            dp[k - 1][i - 2] - prices[i - 1]
                    );
                }

                b = Math.max(
                        b,
                        prices[i] + backup
                );

                dp[k][i] = Math.max(a, b);
            }
        }

        return dp[rowCount - 1][colCount - 1];
    }
}
