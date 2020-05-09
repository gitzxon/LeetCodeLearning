package study.array.TopKIncreasingArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 不是 leetcode，没有 test case，只能自己测。
 */
public class Solution {
    public List<List<Integer>> topKIncreasing(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> resultContainer = new ArrayList<>();

        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (start == end) {
                end++;
                continue;
            }

            if (nums[end] <= nums[end - 1]) {
                List<Integer> cur = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    cur.add(nums[i]);
                }
                resultContainer.add(cur);
                start = end;
            }
            end++;
        }

        List<Integer> cur = new ArrayList<>();
        for (int i = start; i < end; i++) {
            cur.add(nums[i]);
        }
        resultContainer.add(cur);

        resultContainer.sort(Comparator.comparingInt(List::size));

        List<List<Integer>> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int idx = resultContainer.size() - i - 1;
            if (idx >= 0 && idx < resultContainer.size()) {
                topK.add(resultContainer.get(idx));
            }
        }

        return topK;
    }
}
