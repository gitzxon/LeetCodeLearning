package study.misc.ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int start = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > min) {
                start = i;
            }
        }
        if (start == -1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < max) {
                end = i;
            }
        }
        if (end == -1) {
            return 0;
        }

        return end - start + 1;

    }


    public int findUnsortedSubarrayOld(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 0;
        }

        int[] localNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(localNums);

        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < localNums.length; i++) {
            start = i;
            if (nums[i] != localNums[i]) {
                break;
            }
        }

        if (start == end) {
            return 0;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            end = i;
            if (nums[i] != localNums[i]) {
                break;
            }
        }

        return end - start + 1;
    }


}
