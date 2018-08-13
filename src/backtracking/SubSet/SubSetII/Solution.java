package backtracking.SubSet.SubSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper1(nums, new ArrayList<>(), new ArrayList<>(), 0);
    }

    /**
     * 解法1
     * @param nums
     * @param resultContainer
     * @param currentUsedList
     * @param startIndex
     * @return
     */
    private List<List<Integer>> helper1(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentUsedList, int startIndex) {

        resultContainer.add(new ArrayList<>(currentUsedList));

        if (startIndex >= nums.length) {
            return resultContainer;
        }

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            currentUsedList.add(nums[i]);
            helper1(nums, resultContainer, currentUsedList, i + 1);
            currentUsedList.remove(currentUsedList.size() - 1);
        }

        return resultContainer;
    }


    /**
     * 解法2
     * @param nums
     * @param resultContainer
     * @param currentUsedList
     * @param startIndex
     * @return
     */
    private List<List<Integer>> helper2(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentUsedList, int startIndex) {

        resultContainer.add(new ArrayList<>(currentUsedList));
        if (startIndex >= nums.length) return resultContainer;

        Integer pre = null;
        for (int i = startIndex; i < nums.length; i++) {
            if (pre != null && nums[i] == pre) {
                continue;
            }

            currentUsedList.add(nums[i]);
            helper2(nums, resultContainer, currentUsedList, i + 1);
            currentUsedList.remove(currentUsedList.size() - 1);
            pre = nums[i];
        }

        return resultContainer;
    }
}