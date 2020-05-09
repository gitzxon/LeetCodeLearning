package study.array.MedianOfTwoSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return calMedian(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return calMedian(nums1);
        }

        if (nums1.length == 1 && nums2.length == 1) {
            return ((double) (nums1[0] + nums2[0])) / 2;
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // i + j = m - 1 - i + 1 + n - 1 - j + 1
        // => i + j = (m + n) / 2 if (m + n) is even or (m + n + 1) / 2 if (m + n) is odd
        // 0123,01234 , i + j = 2 + 3 = 4, m + n = 9
        // 注意 nums2 的 3 被划分到了 right part。
        // 太 tm 难了。智商不够用了。
        // todo
        /**
         * 这里这个 + 1 需要仔细看看。
         * 我们根本要保证的等式是: (i + j) * 2 = m + n
         * 但是，想两边同时除以二，需要谨慎。因为这是计算机。不是数学。
         * j 只能取整数。
         * 那么，先假设 j 可以取小数，那么 在 m+n 为奇数的时候，可能会出现 j=x.5 的情况。
         * 根据我们的定义，i，j 都是大的那边的开始，那么 j 应该往大了取，即取天花板函数，ceiling。
         * 所以，利用计算机上除法常用套路，可以 + 1 然后 / 2
         */
        int sumForIJ = (m + n + 1) / 2;
        int start = 0;
        int end = m - 1;
        while (true) {
//            int i = (start + end) / 2;
            int i = start + (end - start) / 2;
            int j = sumForIJ - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                start = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

    }

    private double calMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            int a = nums[nums.length / 2];
            int b = nums[nums.length / 2 - 1];
            return ((double) (a + b)) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }
}