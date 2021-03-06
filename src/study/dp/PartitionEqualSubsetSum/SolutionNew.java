package study.dp.PartitionEqualSubsetSum;

public class SolutionNew {
    class Solution {
        public boolean canPartition(int[] nums) {

            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            if (sum % 2 != 0) {
                return false;
            }

            int target = (int) (sum / 2);

            int colCount = target + 1;
            int[] dp = new int[colCount];
            dp[0] = 1;

            for (int row = 0; row < nums.length; row++) {
                for (int i = colCount - 1; i >= 0; i--) {
                    if (i >= nums[row]) {
                        if (dp[i - nums[row]] == 1 || dp[i] == 1) {
                            dp[i] = 1;
                        } else {
                            dp[i] = 0;
                        }
                    }
                }
            }

            return dp[target] == 1;
        }


        public boolean canPartitionBak(int[] nums) {

            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            if (sum % 2 != 0) {
                return false;
            }

            int target = (int) (sum / 2);

            int rowCount = nums.length + 1;
            int colCount = target + 1;
            int[][] dp = new int[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < colCount; i++) {
                dp[0][i] = 0;
            }
            dp[0][0] = 1;

            for (int i = 1; i < rowCount; i++) {

                for (int j = 1; j < colCount; j++) {

                    if (dp[i - 1][j] == 1) {
                        dp[i][j] = 1;
                    } else {
                        int num = nums[i - 1];
                        if (j - num >= 0) {
                            if (dp[i - 1][j - num] == 1) {
                                dp[i][j] = 1;
                            }
                        }

                    }
                }
            }

            boolean result = false;
            for (int i = 0; i < rowCount; i++) {
                if (dp[i][target] == 1) {
                    result = true;
                    break;
                }
            }

            return result;

        }

    }

}
