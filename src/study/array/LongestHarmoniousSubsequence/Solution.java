package study.array.LongestHarmoniousSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int result = 0;

        int start1 = 0;
        int start2 = getNextStart(nums, start1);

        while (start2 != -1) {

            if (nums[start2] - nums[start1] != 1) {
                // do nothing
            } else {

                int start3 = getNextStart(nums, start2);
                if (start3 == -1) {
                    start3 = nums.length;
                }

                int len = start3 - start1;
                if (result < len) {
                    result = len;
                }
            }

            start1 = start2;
            start2 = getNextStart(nums, start1);
        }

        return result;
    }

    private int getNextStart(int[] nums, int current) {
        int next = current;
        while (next < nums.length && nums[next] == nums[current]) {
            next++;
        }

        if (next == nums.length) {
            return -1;
        } else {
            return next;
        }
    }

    public int findLHS_UsingMap(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int num = integerIntegerEntry.getKey();
            int count = integerIntegerEntry.getValue();

            if (map.get(num - 1) != null) {
                int tmp = map.get(num - 1) + count;
                if (tmp > result) {
                    result = tmp;
                }
            }

            if (map.get(num + 1) != null) {
                int tmp = map.get(num + 1) + count;
                if (tmp > result) {
                    result = tmp;
                }
            }
        }

        return result;
    }
}