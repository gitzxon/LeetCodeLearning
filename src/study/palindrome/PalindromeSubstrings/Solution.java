package study.palindrome.PalindromeSubstrings;

import java.util.Arrays;

class Solution {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        int len = s.length();
        int[][] dp = new int[len][len];

        for (int substringLen = 1; substringLen <= len; substringLen++) {
            for (int i = 0; i < len; i++) {
                int j = i + substringLen - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j < len) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i == j - 1) {
                            dp[i][j] = 1;
                        } else if (dp[i + 1][j - 1] != 0){
                            dp[i][j] = dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 0;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[i][j] > 0) {
                    count += 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return count;
    }
}