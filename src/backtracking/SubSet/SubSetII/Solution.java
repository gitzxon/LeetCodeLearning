package backtracking.SubSet.SubSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> helper(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentUsedList, int startIndex) {

        resultContainer.add(new ArrayList<>(currentUsedList));
        if (startIndex >= nums.length) return resultContainer;

        Integer pre = null;
        for (int i = startIndex; i < nums.length; i++) {
            if (pre != null && nums[i] == pre) {
                continue;
            }

            currentUsedList.add(nums[i]);
            helper(nums, resultContainer, currentUsedList, i + 1);
            currentUsedList.remove(currentUsedList.size() - 1);
            pre = nums[i];
        }

        return resultContainer;
    }
}