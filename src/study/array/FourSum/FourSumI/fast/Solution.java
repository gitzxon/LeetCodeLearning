package study.array.FourSum.FourSumI.fast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        return helper(nums, target, 4, 0, nums.length - 1, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> helper(
            int[] nums, int target, int k,
            int startIndex, int endIndex,
            List<List<Integer>> resultContainer,
            List<Integer> curResult
    ) {

        if (k == 2) {
            int i = startIndex;
            int j = endIndex;
            while (i < j) {
                boolean moveI = false;
                boolean moveJ = false;
                if (nums[i] + nums[j] == target) {
                    List<Integer> result = new ArrayList<>(curResult);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    resultContainer.add(result);
                    i++;
                    j--;
                    moveI = true;
                    moveJ = true;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                    moveI = true;

                } else if (nums[i] + nums[j] > target) {
                    j--;
                    moveJ = true;

                }
                if (moveI) {
                    while (i >= 1 && i < nums.length && nums[i] == nums[i - 1]) {
                        i++;
                    }
                }
                if (moveJ) {
                    while (j >= 0 && j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
            }
        } else {

            int i = startIndex;
            while (i <= endIndex) {
                curResult.add(nums[i]);
                helper(nums, target - nums[i], k - 1, i + 1, endIndex, resultContainer, curResult);
                curResult.remove(curResult.size() - 1);
                i++;
                while (i >= 1 && i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return resultContainer;

    }
}