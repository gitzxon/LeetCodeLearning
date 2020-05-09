package study.array.SlidingWindow.SmallestRangeWithCoveringElementsFromKLists;

import java.util.*;

/**
 * 对于重复的数字，只保留自己的那个 row 就可以，因为扫描的过程中还会扫到的。
 * 如果，每一个重复数字都保留所有的 row list，就会有重复计算的问题。
 * SolutionOld 里面的超时应该也是这个原因。
 */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int totalLength = 0;
        for (int i = 0; i < nums.size(); i++) {
            totalLength += nums.get(i).size();
        }

        List<int[]> totalNums = new ArrayList<>(totalLength);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                totalNums.add(new int[] { nums.get(i).get(j), i});
            }
        }
        Collections.sort(totalNums, Comparator.comparingInt(o -> o[0]));

        // row index to count
        HashMap<Integer, Integer> progressMapRowToCount = new HashMap<>();

        int left = 0;
        int right = 0;
        int resultStart = 0;
        int resultEnd = 0;
        boolean resultGot = false;

        while (right < totalNums.size()) {
            int rightValue = totalNums.get(right)[0];
            int rightIndex = totalNums.get(right)[1];
            progressMapRowToCount.put(rightIndex, progressMapRowToCount.getOrDefault(rightIndex, 0) + 1);

            while (progressMapRowToCount.size() == nums.size() && left <= right) {
                int leftValue = totalNums.get(left)[0];
                int leftIndex = totalNums.get(left)[1];
                if (resultGot) {
                    if (rightValue - leftValue < resultEnd - resultStart) {
                        resultEnd = rightValue;
                        resultStart = leftValue;
                    }
                } else {
                    resultStart = leftValue;
                    resultEnd = rightValue;
                    resultGot = true;
                }


                int count = progressMapRowToCount.getOrDefault(leftIndex, 1) - 1;
                if (count == 0) {
                    progressMapRowToCount.remove(leftIndex);
                } else {
                    progressMapRowToCount.put(leftIndex, count);
                }

                left++;
            }

            right++;
        }

        int[] result = new int[2];
        if (resultGot) {
            result[0] = resultStart;
            result[1] = resultEnd;
        } else {
            result[0] = -1;
            result[1] = -1;
        }

        return result;
    }
}