package study.AllHard.BurstBalloons.review1.dp;

class Solution {
    public int maxCoins(int[] nums) {

        int newLen = nums.length + 2;
        int[] newNums = new int[newLen];

        System.arraycopy(
                nums, 0,
                newNums, 1,
                nums.length
        );

        newNums[0] = 1;
        newNums[newLen - 1] = 1;

        int[][] dp = new int[newLen][newLen];

        for (int k = 2; k < newLen; k++) {

            for (int left = 0; left < newLen - k; left++) {

                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(
                            dp[left][right],
                            newNums[i] * newNums[left] * newNums[right] + dp[left][i] + dp[i][right]
                    );
                }

            }
        }
        return dp[0][newLen - 1];
    }
}