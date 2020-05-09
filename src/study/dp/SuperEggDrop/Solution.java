package study.dp.SuperEggDrop;


class Solution {
    public int superEggDrop(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];
        int rowCount = floors + 1;
        int colCount = eggs + 1;
        for (int i = 1; i < colCount; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < rowCount; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i < rowCount; i++) {
            for (int j = 2; j < colCount; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            if (dp[i][eggs] >= floors) {
                return i;
            }
        }
        return -1;
    }
}