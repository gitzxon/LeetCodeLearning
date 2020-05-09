package study.search.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 3, 0, 0);
    }

    private List<List<Integer>> helper(
            int[] nums,
            int targetCount,
            int targetSum,
            int currentIndex
    ) {

        List<List<Integer>> resultContainer = new ArrayList<>();

        if (targetCount == 2) {
            int i = currentIndex;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == targetSum) {
                    List<Integer> result = new ArrayList<>(2);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    resultContainer.add(result);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;

                } else if (nums[i] + nums[j] > targetSum) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {

            for (int i = currentIndex; i < nums.length; i++) {

                if (i > currentIndex && nums[i] == nums[i - 1]) {
                    continue;
                }

                List<List<Integer>> res = helper(
                        nums,
                        targetCount - 1,
                        targetSum - nums[i],
                        i + 1
                );

                if (res != null && res.size() != 0) {
                    for (int j = 0; j < res.size(); j++) {
                        res.get(j).add(0, nums[i]);
                    }

                    resultContainer.addAll(res);
                }


            }

        }

        return resultContainer;

    }
}
