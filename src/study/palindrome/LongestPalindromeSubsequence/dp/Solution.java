package study.palindrome.LongestPalindromeSubsequence.dp;

class Solution {
    public int longestPalindromeSubseq(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int k = 2; k <= len; k++) {
            for (int left = 0; left <= len - k; left++) {
                int right = left + k - 1;
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}