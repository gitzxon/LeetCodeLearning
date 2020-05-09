package study.dp.LongestCommonSubsequence;

public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String s1, String s2) {

        if (s1 == null || s2 == null
                || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        // write your code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i][j-1]
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}