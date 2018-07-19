package array.Permutation.NextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {

        int pivot = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }

        int rightmostMoreThanPivot = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[pivot]) {
                rightmostMoreThanPivot = i;
                break;
            }
        }

        if (rightmostMoreThanPivot == -1) {
            // not possible
            return;
        }

        swap(nums, pivot, rightmostMoreThanPivot);
        reverse(nums, pivot + 1);
        return;
    }

    public void reverse(int[] nums, int startIndex) {
        int head = startIndex;
        int tail = nums.length - 1;
        while (head < tail) {
            swap(nums, head, tail);
            head += 1;
            tail -= 1;
        }
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}