package study.dp.LongestValidParentheses;

class Solution {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (checkIsLeft(c)) {
                dp[i] = 0;
                continue;
            }

            if (checkIsRight(c)) {
                 if (checkIsLeft(s.charAt(i - 1))) {
                     if (i - 2 >= 0) {
                         dp[i] = dp[i - 2] + 2;
                     } else {
                         dp[i] = 2;
                     }
                 } else {
                     if (dp[i - 1] > 0) {
                         int start = i - 1 - dp[i - 1];
                         if (start >= 0 && checkIsLeft(s.charAt(start))) {
                             dp[i] = dp[i - 1] + 2;

                             int end = start - 1;
                             if (end >= 0 && dp[end] > 0) {
                                 dp[i] += dp[end];
                             }
                         }
                     }
                 }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean checkIsRight(char c) {
        return c == ')';
    }

    private boolean checkIsLeft(char c) {
        return c == '(';
    }
}