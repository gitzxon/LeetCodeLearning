package study.array.NumberOfLongestIncreasingSubsequence;


import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {

        int[] dpLength = new int[nums.length];
        int[] dpCount = new int[nums.length];

        Arrays.fill(dpLength, 1);
        Arrays.fill(dpCount, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dpLength[i] < dpLength[j] + 1) {
                        dpLength[i] = dpLength[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dpLength[i] == dpLength[j] + 1) {
                        dpCount[i] += dpCount[j];
                    }
                } else if (nums[i] == nums[j]) {
                    dpLength[i] = dpLength[j];
                    dpCount[i] = dpCount[j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dpLength.length; i++) {
            if (dpLength[i] > max) {
                max = dpLength[i];
            }
        }

        System.out.println("max = " + max);
        int count = 0;
        for (int i = 0; i < dpLength.length; i++) {
            if (dpLength[i] == max) {
                count += dpCount[i];
            }
        }

        return count;
    }
}