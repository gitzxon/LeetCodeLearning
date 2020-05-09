package study.array.MaxSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int resultLength = nums.length - k + 1;
        int[] result = new int[resultLength];

        Deque<Integer> indexDequeue = new LinkedList<>();

        int windowStartIndex = 0;
        int windowEndIndex = 0;
        int nextResultIndex = 0;
        while (windowEndIndex - windowStartIndex + 1 <= k) {
            while (!indexDequeue.isEmpty() && nums[indexDequeue.getLast()] < nums[windowEndIndex]) {
               indexDequeue.removeLast();
            }
            indexDequeue.offerLast(windowEndIndex);
            windowEndIndex++;
        }

        result[nextResultIndex] = nums[indexDequeue.getFirst()];
        nextResultIndex += 1;

        while (windowEndIndex < nums.length) {
            while (!indexDequeue.isEmpty() && nums[indexDequeue.getLast()] < nums[windowEndIndex]) {
                indexDequeue.removeLast();
            }

            indexDequeue.offerLast(windowEndIndex);
            if (nums[windowStartIndex] == nums[indexDequeue.getFirst()]) {
                indexDequeue.removeFirst();
            }

            result[nextResultIndex] = nums[indexDequeue.getFirst()];
            nextResultIndex += 1;

            windowStartIndex += 1;
            windowEndIndex += 1;
        }

        return result;
    }
}