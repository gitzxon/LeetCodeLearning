package study.dp.MaximumSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] dp = new int[rowCount + 1][colCount + 1];
        int maxEdge = 0;
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i-1][j-1]) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }

        return maxEdge * maxEdge;
    }
}