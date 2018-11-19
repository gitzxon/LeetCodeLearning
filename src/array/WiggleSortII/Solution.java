package array.WiggleSortII;

class Solution {
    // 小 大 小 大 小
    public void wiggleSort(int[] nums) {

        if (nums == null) return;
        if (nums.length <= 2) return;

        int k;
        if (nums.length % 2 == 0) {
            k = nums.length / 2;
        } else {
            k = nums.length / 2 + 1;
        }
        findKthLargest(nums, k);
        int theK = nums[k];

        // 需要弄一个 mapping 出来。
        // (1 + i * 2) % (n | 1)
        int start1;
        int start2;
        if (nums.length % 2 == 0) {
            start1 = (nums.length - 1) % 2;
            start2 = (nums.length - 1) % 2 + 1;
        } else {
            start1 = nums.length % 2 - 1;
            start2 = nums.length % 2 + 1;
        }
        for (int i = start1; i >= 0; i--) {
            if (nums[i] == theK) {
                swap(nums, i, start1 - i);
            } else {
                break;
            }
        }

        for (int i = start2; i <= nums.length - 1; i++) {
            if (nums[i] == theK) {
                swap(nums, i, nums.length - 1 + start2 - i);
            } else {
                break;
            }
        }

        int mid = (nums.length - 1) / 2;
        for (int i = mid; i >= 0; i--) {
            swap(nums, i, i * 2);
        }

    }

    private int findKthLargest(int[] nums, int k) {
        return findKthHelper(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthHelper(int[] nums, int lo, int hi, int key) {
        int pivot = nums[hi];
        int current = lo;
        int i = lo;
        while (i <= hi - 1) {
            if (nums[i] <= pivot) {
                swap(nums, i, current);
                current++;
            }
            i++;
        }
        swap(nums, current, hi);
        if (current == key) {
            return nums[current];
        } else if (current < key) {
            return findKthHelper(nums, current + 1, hi, key);
        } else {
            return findKthHelper(nums, lo, current - 1, key);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}