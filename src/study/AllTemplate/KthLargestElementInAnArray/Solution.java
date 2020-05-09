package study.AllTemplate.KthLargestElementInAnArray;

/**
 * partition 只负责找。结果由外层循环判断。
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int target = nums.length - k + 1;
        while (lo < hi) {
            int p = partition(nums, lo, hi);
            if (p == target - 1) {
                return nums[p];
            } else if (p > target - 1) {
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }

        return nums[lo];
    }

    private int partition(int[] nums, int start, int end) {
        int lo = start;
        int hi = start;
        int pivot = nums[end];
        while (hi < end) {
            if (nums[hi] < pivot) {
                swap(nums, lo, hi);
                lo++;
            }
            hi++;
        }

        swap(nums, end, lo);
        return lo;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}