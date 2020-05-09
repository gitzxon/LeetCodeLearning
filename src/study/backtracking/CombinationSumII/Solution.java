package study.backtracking.CombinationSumII;

import java.util.*;

@SuppressWarnings("Duplicates")
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int candidate : candidates) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }
        return helper(new ArrayList<>(), map, target, new ArrayList<>());
    }

    public List<List<Integer>> helper(List<List<Integer>> resultContainer, LinkedHashMap<Integer, Integer> candidates, int target, List<Integer> curNums) {
        if (target == 0) {
            List<Integer> aResult = new ArrayList<>();
            aResult.addAll(curNums);
            resultContainer.add(aResult);
            return resultContainer;
        } else if (target < 0) {
            return resultContainer;
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : candidates.entrySet()) {
            int num = integerIntegerEntry.getKey();
            int count = integerIntegerEntry.getValue();

            if (curNums.size() != 0 && num <= curNums.get(curNums.size() - 1)) {
                continue;
            }

            for (int i = 1; i <= count; i++) {

                for (int j = 0; j < i; j++) {
                    curNums.add(num);
                }

                helper(resultContainer, candidates, target - num * i, curNums);

                for (int j = 0; j < i; j++) {
                    removeTail(curNums);
                }
            }
        }

        return resultContainer;
    }

    public void removeTail(List<Integer> list) {
        list.remove(list.size() - 1);
    }
}