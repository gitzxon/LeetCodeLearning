package study.array.MaxConsecutiveOnesIII;

/**
 * fast version
 */
public class Solution2 {

    public int longestOnes(int[] nums, int k) {

        int remain = k;
        int start = 0;
        int end;
        for (end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                remain -= 1;
            }

            if (remain < 0) {
                if (nums[start] == 0) {
                    remain++;
                }
                start++;
            }
        }
        return end - start;
    }
}
