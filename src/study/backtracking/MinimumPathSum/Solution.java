package study.backtracking.MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }


        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[][] dp = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = grid[0][0];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // top
                if (checkRowColValid(rowCount, colCount, i - 1, j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }

                // left
                if (checkRowColValid(rowCount, colCount, i, j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }

        return dp[rowCount - 1][colCount - 1];
    }

    private boolean checkRowColValid(int rowCount, int colCount, int curRow, int curCol) {
        return (curRow >= 0 && curRow < rowCount && curCol >= 0 && curCol < colCount);
    }
}
