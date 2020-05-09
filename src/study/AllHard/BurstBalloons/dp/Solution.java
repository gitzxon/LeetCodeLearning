package study.AllHard.BurstBalloons.dp;

class Solution {
    public int maxCoins(int[] nums) {

        int fakeCount = nums.length + 2;
        int[] newNums = new int[fakeCount];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }

        newNums[0] = 1;
        newNums[fakeCount - 1] = 1;

        int[][] dp = new int[fakeCount][fakeCount];

        for (int k = 2; k < fakeCount; k++) {
            for (int left = 0; left < fakeCount - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(
                            dp[left][right],
                            dp[left][i] + dp[i][right] + newNums[i] * newNums[left] * newNums[right]
                    );
                }

            }
        }
        return dp[0][fakeCount - 1];
    }
}