package study.array.ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

class Solution {

    int[] mOriginNums = null;
    int[] mNums;

    public Solution(int[] nums) {
        mOriginNums = Arrays.copyOf(nums, nums.length);
        mNums = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        mNums = Arrays.copyOf(mOriginNums, mOriginNums.length);
        return mNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();

        for (int i = 0; i < mNums.length; i++) {
            int target = random.nextInt(mNums.length);
            swap(mNums, i, target);
        }
        return mNums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */