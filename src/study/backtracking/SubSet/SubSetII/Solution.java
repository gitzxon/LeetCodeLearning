package study.backtracking.SubSet.SubSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * 核心是怎么解决大哥能指定带小弟，而小弟不能成为大哥的问题。
     * 2，3 是一样的。
     * 1 是 from leetcode discuss
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper3(nums, new ArrayList<>(), new ArrayList<>(), 0);
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

    /**
     * 解法3
     * @param nums
     * @param resultContainer
     * @param currentUsedList
     * @param startIndex
     * @return
     */
    private List<List<Integer>> helper3(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentUsedList, int startIndex) {

        resultContainer.add(new ArrayList<>(currentUsedList));
        if (startIndex >= nums.length) return resultContainer;

        int preIndex = -1;
        for (int i = startIndex; i < nums.length; i++) {
            if (preIndex != -1 && nums[i] == nums[preIndex]) {
                continue;
            }
            preIndex = i;

            currentUsedList.add(nums[i]);
            helper3(nums, resultContainer, currentUsedList, i + 1);
            currentUsedList.remove(currentUsedList.size() - 1);


        }

        return resultContainer;
    }
}