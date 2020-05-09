package study.palindrome.CountDifferentPalindromicSubsequences;

class Solution {
    public int countPalindromicSubsequences(String string) {

        int len = string.length() + 1;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < len; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int k = 2; k < len; k++) {
            for (int left = 1; left <= len - k; left++) {
                int right = left + k - 1;
                char c1 = string.charAt(left - 1);
                char c2 = string.charAt(right - 1);
                if (c1 == c2) {
                    dp[left][right] = 1 + dp[left + 1][right - 1] +
                            dp[left + 1][right] + dp[left][right - 1] - dp[left + 1][right - 1];
                } else {
                    dp[left][right] =
                            dp[left + 1][right] + dp[left][right - 1] - dp[left + 1][right - 1];
                }
            }
        }

        return dp[1][string.length()];
    }
}