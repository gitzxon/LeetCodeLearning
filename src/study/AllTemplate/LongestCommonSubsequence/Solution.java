package study.AllTemplate.LongestCommonSubsequence;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int rowCount = text1.length() + 1;
        int colCount = text2.length() + 1;
        int[][] dp = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < colCount; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[rowCount - 1][colCount - 1];
    }
}