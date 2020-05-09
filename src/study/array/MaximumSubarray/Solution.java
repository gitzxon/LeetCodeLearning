package study.array.MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        long maxSoFar = nums[0];
        long maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
            } else {
                maxEndingHere = nums[i] + maxEndingHere;
            }

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return (int) maxSoFar;
    }
}