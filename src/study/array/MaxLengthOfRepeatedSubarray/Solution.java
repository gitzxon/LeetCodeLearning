package study.array.MaxLengthOfRepeatedSubarray;

public class Solution {
    public int findLength(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return 0;
        }

        int aLen = a.length;
        int bLen = b.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        int max = 0;
        for (int i = 0; i <= aLen; i++) {
            for (int j = 0; j <= bLen; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
