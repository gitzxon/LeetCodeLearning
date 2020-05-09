package study.num.FindMissingNumber;

class Solution {
    public int missingNumber(int[] nums) {
        int min = 0;
        int max = nums.length;
        long sum = (max + min) * (max + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return (int) sum;
    }
}