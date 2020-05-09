package study.array.Permutation.NextPermutation;

/**
 * 总结一下流程：
 * 1. 找到最长递减 suffix。
 * 2. 找 pivot
 * 3. suffix 中找到比 pivot 大的最小的数 X
 * 4. swap pivot and X
 * 5. reverse new suffix
 */
class Solution {
    public void nextPermutation(int[] nums) {

        // 找最长递减 suffix 起点
        // pivot = start - 1
        int pivot = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        // pivot 无效，说明整个数组就是那个递减 suffix，
        // ß所以，直接 reverse
        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }

        // suffix 中比 pivot 大的最小的数
        // suffix 是递减的，所以从右往左找第一个即可
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