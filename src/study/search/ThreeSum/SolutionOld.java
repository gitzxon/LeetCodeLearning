package study.search.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class SolutionOld {

    private HashMap<Integer, Integer> mNumsToIndexMap = new HashMap<>(5000);
    private final int mTargetCount = 3;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        mNumsToIndexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                mNumsToIndexMap.put(nums[i], i);
            }
        }
        return helper(new ArrayList<>(), nums, new ArrayList<>(), 0, 0, 0);
    }


    private List<List<Integer>> helper(
            List<List<Integer>> resultContainer,
            int[] nums,
            List<Integer> currentList,
            int nextIndex,
            int currentCount,
            int currentSum
    ) {
        if (currentCount == mTargetCount) {
            if (currentSum == 0) {
                List<Integer> tmpResult = new ArrayList<>(3);
                tmpResult.addAll(currentList);
                resultContainer.add(tmpResult);
            }
            return resultContainer;
        }

        if (nextIndex >= nums.length) {
            return resultContainer;
        }

        // -4, -1, -1, 0, 1, 2
        for (int i = nextIndex; i < nums.length; i++) {

            if (currentSum >= 0 && nums[i] > 0) {
                continue;
            }

            if (currentCount == mTargetCount - 1 && !mNumsToIndexMap.containsKey(0 - currentSum)) {
                continue;
            }

            if (i >= 1 && nums[i] == nums[i-1]) {
                // handle same num
                int startIndexForThisNum = mNumsToIndexMap.get(nums[i]);
                int tmpIndex = i - startIndexForThisNum; // 0, 1, 2, 3 ...

                int startIndexInCurrentList = currentList.size() - tmpIndex;
                if ( !(startIndexInCurrentList >= 0
                        && currentList.get(startIndexInCurrentList) == nums[i])) {
                    continue;
                }
            }

            currentList.add(nums[i]);
            helper(
                    resultContainer,
                    nums,
                    currentList,
                    i + 1,
                    currentCount + 1,
                    currentSum + nums[i]);
            currentList.remove(currentList.size() - 1);
        }

        return resultContainer;

    }
}