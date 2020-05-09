package study.array.MedianOfTwoSortedArrays.mine;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedian(nums2);
        } else if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start1 = 0;
        int end1 = nums1.length - 1;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        int leftCount = (totalLen + 1) / 2;

        while (start1 <= end1 || end1 == -1 || start1 == len1) {

            int mid1 = (start1 + end1) >>> 1;
            if (end1 == -1) {
                mid1 = -1;
            } else if (start1 == len1) {
                mid1 = len1;
            }
            int mid2 = leftCount - (mid1 + 1) - 1;

            int a1 = getValueSafe(nums1, mid1, Integer.MIN_VALUE);
            int a2 = getValueSafe(nums1, mid1 + 1, Integer.MAX_VALUE);

            int b1 = getValueSafe(nums2, mid2, Integer.MIN_VALUE);
            int b2 = getValueSafe(nums2, mid2 + 1, Integer.MAX_VALUE);

            if (a1 > b2) {
                end1 = mid1 - 1;
            } else if (b1 > a2) {
                start1 = mid1 + 1;
            } else {
                if (totalLen % 2 == 0) {
                    return ((double) Math.max(a1, b1) + (double) Math.min(a2, b2)) / 2;
                } else {
                    return Math.max(a1, b1);
                }
            }
        }
        return 0;
    }

    private double findMedian(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length % 2 == 0) {
            return ((double) (nums[nums.length / 2] + nums[nums.length / 2 - 1])) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }

    private int getValueSafe(int[] nums, int i, int defaultValue) {
        if (i >= 0 && i < nums.length) {
            return nums[i];
        } else {
            return defaultValue;
        }
    }
}
