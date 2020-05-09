package study.dp.LongestCommonSubsequence.review;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int l1 = text1.length();
        int l2 = text2.length();

        int rowCount = l1 + 1;
        int colCount = l2 + 1;
        int[][] dp = new int[rowCount][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}