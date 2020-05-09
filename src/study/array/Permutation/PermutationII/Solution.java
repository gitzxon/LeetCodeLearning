package study.array.Permutation.PermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> permutationContainer = new ArrayList<>();
        addPermutation(permutationContainer, nums);

        while (true) {
            int res = performGenerateNextPermutationInPlace(nums);
            if (res != -1) {
                addPermutation(permutationContainer, nums);
            } else {
                break;
            }
        }

        return permutationContainer;
    }

    private void addPermutation(List<List<Integer>> permutationContainer, int[] ints) {
        permutationContainer.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
    }

    private int performGenerateNextPermutationInPlace(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0);
            return -1;
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
            return 0;
        }

        swap(nums, pivot, rightmostMoreThanPivot);
        reverse(nums, pivot + 1);
        return 0;
    }

    private void reverse(int[] nums, int startIndex) {
        int head = startIndex;
        int tail = nums.length - 1;
        while (head < tail) {
            swap(nums, head, tail);
            head += 1;
            tail -= 1;
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}