package study.array.LongestIncreasingSubsequence;

/**
 * write lis myself.
 * and use a simple binary search to find the correct index to replace.
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
                smallestEnd[binarySearch(smallestEnd, 0, curLen, nums[i])] = nums[i];
            }
        }
        return curLen;
    }

    private int binarySearch(int[] smallestEnd, int start, int end, int num) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (smallestEnd[mid] == num) {
                return mid;
            } else if (smallestEnd[mid] > num) {
                end = mid - 1;
            } else if (smallestEnd[mid] < num) {
                start = mid + 1;
            }
        }
        return start;
    }

}
