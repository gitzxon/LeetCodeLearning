package study.AllHard.BurstBalloons.review1.divideandconquer;

class Solution {
    public int maxCoins(int[] nums) {

        int newLen = nums.length + 2;
        int[] newNum = new int[newLen];
        System.arraycopy(
                nums, 0,
                newNum, 1,
                nums.length
        );
        newNum[0] = 1;
        newNum[newLen - 1] = 1;

        int[][] mem = new int[newLen][newLen];
        performDivideAndConquer(
                newNum, mem,
                0, newLen - 1
        );

        return mem[0][newLen - 1];
    }

    private int performDivideAndConquer(
            int[] nums, int[][] mem,
            int start, int end
    ) {

        if (mem[start][end] != 0) {
            return mem[start][end];
        }

        int max = 0;
        for (int i = start + 1; i < end; i++) {
            int value = nums[i] * nums[start] * nums[end];
            int left = performDivideAndConquer(nums, mem, start, i);
            int right = performDivideAndConquer(nums, mem, i, end);
            max = Math.max(
                    max,
                    value + left + right
            );
        }
        mem[start][end] = max;

        return mem[start][end];
    }

}