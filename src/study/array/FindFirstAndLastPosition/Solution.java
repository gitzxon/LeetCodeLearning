package study.array.FindFirstAndLastPosition;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int k = binarySearch(nums, target);
        int[] result = new int[2];
        if (k == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int start = k;
        int end = k;
        while (start >= 0) {
            if (start - 1 >= 0 && nums[start - 1] == nums[k]) {
                start--;
            } else {
                break;
            }
        }

        while (end < nums.length) {
            if (end + 1 < nums.length && nums[end + 1] == nums[k]) {
                end++;
            } else {
                break;
            }
        }

        result[0] = start;
        result[1] = end;
        return result;
    }

    private int binarySearch(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}