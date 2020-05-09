package study.search.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(
                nums,
                4,
                target,
                0
        );
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

                // 这里必须使用 i> currentIndex, 而不是简单的 i-1>0
                // 因为这里只做一个简单的有效性判断是不够的。
                // i > currentIndex 的含义是，不让此 i 后面的相同数字鸠占鹊巢，
                // 比如，不让第二个 i 占用第一个 i 的位置产生重复结果
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