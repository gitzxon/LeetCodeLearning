package study.array.FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length ==0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == -1 || i == nums[i] - 1) {
                i++;
                continue;
            }

            if (!swap(nums, i, nums[i] - 1)) {
                result.add(nums[i]);
                nums[i] = -1;
            }
        }

        return result;
    }

    private boolean swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return false;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return true;
    }
}