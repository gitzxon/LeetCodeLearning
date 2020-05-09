package study.array.KthSmallestElementInASortedMatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路简单但是没有使用 matrix 的特性。
 * 利用 PriorityQueue 来简单粗暴的求解。
 */
class SolutionDirty {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.stream(matrix).forEach(ints -> Arrays.stream(ints).forEach(value -> {
            priorityQueue.add(value);
        }));

        int i = 0;
        int res = Integer.MAX_VALUE;
        while (i < k) {
            res = priorityQueue.poll();
            i+=1;
        }

        return res;
    }
}