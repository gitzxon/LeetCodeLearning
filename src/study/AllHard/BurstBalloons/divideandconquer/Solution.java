package study.AllHard.BurstBalloons.divideandconquer;

class Solution {
    public int maxCoins(int[] nums) {

        int len = nums.length;
        int newLen = len + 2;
        int[][] memorization = new int[newLen][newLen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                memorization[i][j] = 0;
            }
        }

        int[] newNum = new int[newLen];
        for (int i = 0; i < newNum.length; i++) {
            if ( i == 0 || i == newNum.length - 1) {
                newNum[i] = 1;
            } else {
                newNum[i] = nums[i - 1];
            }
        }

        performDivideAndConquer(
                newNum, memorization, 0, newNum.length - 1
        );
        return memorization[0][newLen - 1];
    }

    private int performDivideAndConquer(
            int[] nums,
            int[][] mem,
            int start, int end
    ) {
        if (start + 1 == end) {
            return 0;
        }

        if (mem[start][end] > 0) {
            return mem[start][end];
        }

        int max = 0;
        for (int i = start + 1; i < end; i++) {
            int left = performDivideAndConquer(nums, mem, start, i);
            int right = performDivideAndConquer(nums, mem, i, end);
            max = Math.max(max, nums[i] * nums[start] * nums[end] + left + right);
        }
        mem[start][end] = max;
        return max;
    }

}