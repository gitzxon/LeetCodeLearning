package study.AllTemplate.ThreeSum.ThreeSum.slow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 感觉这个解法应该是没错的，但是超时了。
 * 因为我直接套用 permutation 和 combination 的思路。但是这两个的要求都是，不能丢失。
 * 而这个题，因为我们的目标的 0，所以可以剪枝。
 * todo: fast
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new ArrayList<>(), 0, 0);
    }

    public List<List<Integer>> helper(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentList, long currentValue, int startIndex) {
        if (currentList.size() == 3
                && currentValue == 0) {
            List<Integer> tmp = new ArrayList<>(currentList);
            resultContainer.add(tmp);
            return resultContainer;
        }
        if (currentList.size() == 3 && currentValue != 0) {
            return resultContainer;
        }

        boolean havePre = false;
        int pre = 0;
        for (int i = startIndex; i < nums.length; i++) {

            if (havePre && nums[i] == pre) {
                continue;
            }

            pre = nums[i];
            havePre = true;

            if (currentValue + nums[i] > 0) {
                continue;
            }

            currentList.add(nums[i]);
            helper(nums, resultContainer, currentList, currentValue + nums[i], i + 1);
            currentList.remove(currentList.size() - 1);

        }

        return resultContainer;
    }
}
