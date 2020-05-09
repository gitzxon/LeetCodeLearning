package study.array.FourSum.FourSumI.slow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 其实只是在遍历解空间。所以 282 test case 都过了，但是超时了。
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(new ArrayList<>(), target, nums, 0, 0, new ArrayList<>());
    }

    public List<List<Integer>> helper(List<List<Integer>> resultContainer, int target, int[] nums, int startIndex, int curSum, List<Integer> curList) {
        if (curList.size() == 4 && curSum == target) {
            List<Integer> tmp = new ArrayList<>(curList);
            resultContainer.add(tmp);
            return resultContainer;
        }

        // startIndex + (4 - curList.size()) > nums.length
        if (nums.length - startIndex + curList.size() < 4) {
            return resultContainer;
        }

        if (curList.size() < 4) {


            Integer pre = null;
            for (int i = startIndex; i < nums.length; i++) {

                int cur = nums[i];
                if (pre != null && cur == pre) {
                    continue;
                }
                pre = cur;
                curList.add(cur);
                helper(resultContainer, target, nums, i + 1, cur + curSum, curList);
                curList.remove(curList.size() - 1);
            }
        }

        return resultContainer;
    }
}