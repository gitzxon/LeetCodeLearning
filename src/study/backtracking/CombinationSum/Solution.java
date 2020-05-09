package study.backtracking.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        return helper(new ArrayList<>(), candidates, target, new ArrayList<>());
    }

    public List<List<Integer>> helper(List<List<Integer>> resultContainer, int[] candidates, int target, List<Integer> curNums) {
        if (target == 0) {
            List<Integer> aResult = new ArrayList<>();
            aResult.addAll(curNums);
            resultContainer.add(aResult);
            return resultContainer;
        }

        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (target >= num && (curNums.size() == 0 || num >= curNums.get(curNums.size() - 1))) {
                curNums.add(num);
                helper(resultContainer, candidates, target - num, curNums);
                curNums.remove(curNums.size() - 1);
            }
        }

        return resultContainer;
    }
}