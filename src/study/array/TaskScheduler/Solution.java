package study.array.TaskScheduler;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    /**
     * https://leetcode.com/problems/task-scheduler/
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {

        if (n == 0) {
            return tasks.length;
        }

        int[] countArray = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            countArray[tasks[i] - 'A'] += 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                queue.add(countArray[i]);
            }
        }

        int max = -1;
        int maxCount = 0;
        while (!queue.isEmpty() && queue.peek() >= max) {
            maxCount += 1;
            max = queue.poll();
        }

        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}