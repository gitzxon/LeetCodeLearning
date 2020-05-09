package study.array.LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int a = nums[i] + 1;
                while (set.contains(a)) {
                    a += 1;
                }
                maxLen = Math.max(maxLen, a - nums[i]);
            }
        }
        return maxLen;
    }
}