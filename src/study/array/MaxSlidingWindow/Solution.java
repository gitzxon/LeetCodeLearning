package study.array.MaxSlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            add(nums, i, indexQueue);
        }

        List<Integer> result = new ArrayList<>(nums.length - k + 1);
        result.add(nums[indexQueue.peek()]);

        for (int i = k; i < nums.length; i++) {
            indexQueue.poll();
            add(nums, i, indexQueue);
            result.add(nums[indexQueue.peek()]);
        }

        return unpack(result);
    }

    private void add(int[] nums, int index, Deque<Integer> indexQueue) {
        if (indexQueue.isEmpty()) {
            indexQueue.add(index);
        } else {
            int count = 1;
            while (indexQueue.peekLast() != null && nums[indexQueue.peekLast()] < nums[index]) {
                indexQueue.pollLast();
                count += 1;
            }
            for (int j = 0; j < count; j++) {
                indexQueue.addLast(index);
            }

        }
    }


    private int[] unpack(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}