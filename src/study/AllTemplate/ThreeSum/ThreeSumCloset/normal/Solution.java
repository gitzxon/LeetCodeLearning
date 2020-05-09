package study.AllTemplate.ThreeSum.ThreeSumCloset.normal;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mid;
        int right;
        int min = 0;
        boolean find = false;

        for (int left = 0; left <= nums.length - 2; left++) {
            mid = left + 1;
            right = nums.length - 1;

            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (!find || Math.abs(target - sum) < Math.abs(target - min)) {
                    find = true;
                    min = sum;
                }

                if (sum > target) {
                    right -= 1;
                } else {
                    mid += 1;
                }

            }
        }
        return min;
    }
}