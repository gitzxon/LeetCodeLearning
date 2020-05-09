package study.dp.CountingBits;

public class Solution {

    public int[] countBits(int num) {

        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            int target = i & (i - 1);
            dp[i] = 1 + dp[target];
        }
        return dp;
    }

}
