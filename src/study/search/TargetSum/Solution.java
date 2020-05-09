package study.search.TargetSum;

/**
 *                   sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *                        2 * sum(P) = target + sum(nums)
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int newSum = S + sum;
        if (newSum % 2 == 1) {
            return 0;
        }

        return performTargetSum(nums, newSum / 2);
    }

    private int performTargetSum(int[] nums, int targetSum) {
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = targetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[targetSum];
    }
}