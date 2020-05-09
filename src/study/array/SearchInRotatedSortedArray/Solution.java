package study.array.SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int i = 0;
        int j = nums.length - 1;
        int m = -1;

        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            } else {
                if (onHighSlop(nums, m)) {
                    // 高峰
                    if (nums[m] > target) {
                        if (target >= nums[i]) {
                            j = m - 1;
                        } else {
                            i = m + 1;
                        }
                    } else if (nums[m] < target) {
                        i = m + 1;
                    }
                } else {
                    // 低峰
                    if (nums[m] > target) {
                        j = m - 1;
                    } else if (nums[m] < target) {
                        if (target <= nums[j]) {
                            i = m + 1;
                        } else {
                            j = m - 1;
                        }
                    }
                }
            }
        }

        return -1;

    }

    private boolean onHighSlop(int[] nums, int x) {
        if (nums[x] >= nums[0] && nums[x] >= nums[nums.length - 1]) {
            return true;
        } else {
            return false;
        }
    }
}