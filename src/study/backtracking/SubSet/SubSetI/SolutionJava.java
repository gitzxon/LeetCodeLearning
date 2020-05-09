package study.backtracking.SubSet.SubSetI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionJava {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> helper(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentList, int startIndex) {
        resultContainer.add(new ArrayList<>(currentList));
        if (startIndex >= nums.length) return resultContainer;

        for (int i = startIndex; i < nums.length; i++) {
            currentList.add(nums[i]);
            helper(nums, resultContainer, currentList, i + 1);
            currentList.remove(currentList.size() - 1);
        }
        return resultContainer;
    }
}