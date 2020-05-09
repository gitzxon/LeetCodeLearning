package study.array.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length ==0) {
            return new ArrayList<>();
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == -1 || i == nums[i] - 1) {
                i++;
                continue;
            }

            if (!swap(nums, i, nums[i] - 1)) {
                nums[i] = -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -1) {
                result.add(j + 1);
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