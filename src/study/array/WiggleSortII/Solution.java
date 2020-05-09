package study.array.WiggleSortII;

class Solution {
    // 小 大 小 大 小
    public void wiggleSort(int[] nums) {

        if (nums == null) return;
        if (nums.length <= 1) return;

        int k = (nums.length + 1) / 2;
        int findResult = findKthLargest(nums, k);
        int median = nums[k-1];
        // assert findResult == median
        int left = 0;
        int i = 0;
        int right = nums.length - 1;
        // 需要弄一个 mapping 出来。
        // (1 + i * 2) % (n | 1)
        // 需要自己体悟这种 virtual index 的解法。
        while (i <= right) {
            if (nums[newIndex(i, nums)] > median) {
                swap(nums, newIndex(left, nums), newIndex(i, nums));
                left++;
                i++;
            } else if (nums[newIndex(i, nums)] < median) {
                swap(nums, newIndex(right, nums), newIndex(i, nums));
                right--;
            } else {
                i++;
            }
        }
    }

    public void wiggleSort_good(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }


    private int findKthLargest(int[] nums, int k) {
        return findKthHelper(nums, 0, nums.length - 1, k - 1);
    }

    /**
     * 找到第 k 小的。
     */
    private int findKthHelper(int[] nums, int lo, int hi, int key) {
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

    private int newIndex(int index, int[] nums) {
//        int mod;
//        if (nums.length % 2 == 0) {
//            mod = nums.length + 1;
//        } else {
//            mod = nums.length;
//        }
        // 即，偶数的时候，数组长度 + 1；奇数的时候，数组长度；
        return (1 + 2 * index) % (nums.length | 1);
    }
}