package array.LongestIncreasingSubsequence;

/**
 * write lis myself
 * todo: need to change the while loop to binary search.
 */
public class SolutionMy {

    public int lengthOfLIS(int[] nums) {

        int[] smallestEnd = new int[nums.length];
        int curLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                smallestEnd[curLen] = nums[i];
                curLen += 1;
            } else if (nums[i] < smallestEnd[0]) {
                smallestEnd[0] = nums[i];
            } else if (nums[i] > smallestEnd[curLen - 1]) {
                smallestEnd[curLen] = nums[i];
                curLen += 1;
            } else {
                int j = curLen - 2;
                while (j >= 0) {
                    if (smallestEnd[j] < nums[i]) {
                        smallestEnd[j + 1] = nums[i];
                        break;
                    }
                    j--;
                }
            }
        }
        return curLen;
    }

}
