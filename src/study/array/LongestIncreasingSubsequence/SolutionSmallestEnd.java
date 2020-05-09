package study.array.LongestIncreasingSubsequence;

public class SolutionSmallestEnd {

    public static class Solution {

        public int lengthOfLIS(int[] nums) {

            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }

            int[] smallestEnd = new int[nums.length];
            smallestEnd[0] = nums[0];
            int len = 1;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num < smallestEnd[0]) {
                    smallestEnd[0] = num;
                } else if (num == smallestEnd[0]) {
                    // do nothing
                } else if (num > smallestEnd[len - 1]) {
                    smallestEnd[len] = num;
                    len += 1;
                } else if (num == smallestEnd[len - 1]) {
                    // do nothing
                } else {
                    int position = binarySearch(smallestEnd, 0, len - 1, num);
                    smallestEnd[position] = num;
                }
            }

            return len;
        }

        private int binarySearch(int[] nums, int start, int end, int key) {
            int i = start;
            int j = end;
            int m = -1;
            while (i < j) {
                m = (i + j) / 2;
                if (nums[m] == key) {
                    return m;
                } else if (nums[m] < key) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }

            if (i == j) {
                return m + 1; // for 2,4,5,19 and given 6, expected 2,4,5,6
            } else {
                return m;
            }

        }
    }


}
