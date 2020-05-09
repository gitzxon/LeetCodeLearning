package study.array.MinimumSizeSubarraySum;

// https://www.lintcode.com/problem/minimum-size-subarray-sum/description
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // write your code here
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            if (sum >= s) {
                while (sum >= s && start <= end) {
                    len = Math.min(len, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
            }
            end++;
        }

        if (len == Integer.MAX_VALUE) {
            return -1;
        } else {
            return len;
        }
    }
}
