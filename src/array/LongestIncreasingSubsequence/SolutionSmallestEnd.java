package array.LongestIncreasingSubsequence;

import java.util.Arrays;

public class SolutionSmallestEnd {


    public int lengthOfLIS(int[] nums) {
        int[] smallestEnd = new int[nums.length];
        smallestEnd[0] = nums[0];
        int len = 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < smallestEnd[0]) {
                smallestEnd[0] = num;
            } else if (num > smallestEnd[len - 1]) {
                smallestEnd[len] = num;
                len += 1;
            } else {
                int position = binarySearch(smallestEnd, 0, )
                smallestEnd[position] = num;
            }
        }

        return len;
    }

    private int binarySearch(int[] nums, int start, int end, int key) {
        int i = start;
        int j = end;
        while (i < j) {
            int m = i + j / 2;
            if (nums[m] < key) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return i;
    }
}
