package study.array.Permutation.PermutationSequence;

class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int counter = 1;
        while (counter <= k - 1) {
            getNextPermutation(nums);
            counter += 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    private int[] getNextPermutation(int[] nums) {

        int pivot = nums.length - 2;

        while (pivot >= 0) {
            if (nums[pivot] < nums[pivot + 1]) {
                break;
            }
            pivot -= 1;
        }

        if (pivot == -1) {
            // decrease, next is the first one
            rotate(nums);
            return nums;
        }

        int target = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[pivot]) {
                target = i;
                break;
            }
        }
        swap(nums, pivot, target);
        rotate(nums, pivot + 1, nums.length - 1);
        return nums;
    }

    private int[] rotate(int[] nums) {
        return rotate(nums, 0, nums.length - 1);
    }

    private int[] rotate(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i <= j) {
            swap(nums, i, j);
            i += 1;
            j -= 1;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}