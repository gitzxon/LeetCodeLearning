package study.dp.EditDistance;

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }

        if (word1 == null) {
            return word2.length();
        }

        if (word2 == null) {
            return word1.length();
        }

        if (word1.length() < word2.length()) {
            return performCalculateMinEditDistance(word2, word1);
        } else {
            return performCalculateMinEditDistance(word1, word2);
        }
    }

    public int performCalculateMinEditDistance(String word1, String word2) {
        int rowCount = word2.length() + 1;
        int colCount = word1.length() + 1;
        int[][] dp = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < colCount; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < rowCount; i++) {

            for (int j = 1; j < colCount; j++) {


                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int top = dp[i][j - 1];
                    int leftTop = dp[i - 1][j - 1];
                    int left = dp[i - 1][j];
                    int min = Math.min(Math.min(top, leftTop), left);
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[rowCount - 1][colCount - 1];
    }
}