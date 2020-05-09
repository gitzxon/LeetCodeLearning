package study.ds.heap.KthLargestElementInAnArray;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, nums.length - 1 - i);
            heapify(nums, nums.length - 1 - i, 0);
        }
        return nums[0];
    }

    public void heapify(int[] array, int length, int start) {
        int largest = start;
        int left = start * 2 + 1;
        int right = start * 2 + 2;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != start) {
            swap(array, start, largest);

            heapify(array, length, largest);
        }
    }

    public void swap(int[] array, int a, int b) {
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }
}