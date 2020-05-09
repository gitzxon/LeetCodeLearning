package study.array.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 不需要真正去 swap，只需要标记一下 nums 中到底哪个数字出现过就可以了。
 * 利用数字范围，没有负数，所以我们可以用负数来标记。
 * swap 和负数标记都是修改了原来的数组。
 */
public class SolutionNew {

    class Solution {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int value = Math.abs(nums[i]) - 1;
                if (nums[value] > 0) {
                    nums[value] = -nums[value];
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
}
