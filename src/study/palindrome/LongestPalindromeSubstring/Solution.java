package study.palindrome.LongestPalindromeSubstring;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length() + 1;

        int[][] dp = new int[len + 1][len + 1];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }

        int max = 0;
        int start = -1;
        int end = -1;

        for (int k = 2; k < len; k++) {
            for (int left = 1; left <= len - k; left++) {
                int right = left + k - 1;
                int c1 = s.charAt(left - 1);
                int c2 = s.charAt(right - 1);
                if (c1 == c2 && (k == 2 || dp[left + 1][right - 1] != 0)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = 0;
                }
                if (max < dp[left][right]) {
                    max = dp[left][right];
                    start = left - 1;
                    end = right - 1;
                }
            }
        }

        if (max == 0) {
            return String.valueOf(s.charAt(0));
        }

        return s.substring(start, end + 1);
    }
}
