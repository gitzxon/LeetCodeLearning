package study.search.TargetSum;

/**
 * The recursive solution is very slow, because its runtime is exponential
 */
class SolutionSlow {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        count = 0;
        performDFS(
                nums,
                0,
                0,
                S
        );
        return count;
    }

    private void performDFS(
        int[] nums,
        int curSum,
        int curIndex,
        int targetSum
    ) {
        if (curIndex == nums.length) {
            if (curSum == targetSum) {
                count += 1;
            }

            return;
        }

        int cur = nums[curIndex];
        performDFS(
                nums,
                curSum + cur,
                curIndex + 1,
                targetSum
        );

        performDFS(
                nums,
                curSum - cur,
                curIndex + 1,
                targetSum
        );

    }
}