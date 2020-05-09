package study.array.KthLargestElementInAnArray;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k - 1);
    }

    private int helper(int[] nums, int lo, int hi, int key) {
        int pivot = nums[hi];
        int current = lo;
        int i = lo;
        while (i <= hi - 1) {
            if (nums[i] >= pivot) {
                swap(nums, i, current);
                current++;
            }
            i++;
        }
        swap(nums, current, hi);
        if (current == key) {
            return nums[current];
        } else if (current < key) {
            return helper(nums, current + 1, hi, key);
        } else {
            return helper(nums, lo, current - 1, key);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}