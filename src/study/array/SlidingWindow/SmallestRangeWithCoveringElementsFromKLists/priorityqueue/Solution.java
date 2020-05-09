package study.array.SlidingWindow.SmallestRangeWithCoveringElementsFromKLists.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 跟一般的滑动窗口类题目不同。一般的滑动窗口，是需要每次移动 right 知道条件满足，然后移动 left 使得条件不满足。过程中保存数据。
 * 但是这个题目，因为窗口有类别，所以采用了始终保持类别是都有的，往前滑。
 */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(nums.size(), Comparator.comparingInt(o -> o[0]));
        int[] indexArray = new int[nums.size()];
        Arrays.fill(indexArray, 0);

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(indexArray[i]);
            if (value > end) {
                end = value;
            }
            if (value < start) {
                start = value;
            }
            queue.add(new int[]{value, i});
        }

        int resultStart = start;
        int resultEnd = end;

        while (!queue.isEmpty()) {
            int[] wrapper = queue.poll();
            int idx = wrapper[1];

            int nextCol = indexArray[idx] + 1;
            if (nextCol == nums.get(idx).size()) {
                break;
            }
            int newValue = nums.get(idx).get(nextCol);
            queue.offer(new int[]{newValue, idx});
            indexArray[idx] = nextCol;
            if (newValue > end) {
                end = newValue;
            }

            int[] minWrapper = queue.peek();
            assert minWrapper != null;
            start = minWrapper[0];
            if (end - start < resultEnd - resultStart) {
                resultEnd = end;
                resultStart = start;
            }
        }
        return new int[] {resultStart, resultEnd};
    }
}