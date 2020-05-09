package study.ds.heap.UglyNumberII;

import java.util.PriorityQueue;

class Solution {
    public int nthUglyNumber(int n) {
//        if (n <= 10) {
//            int[] result = new int[] {
//                    1, 2, 3, 4, 5, 6, 8, 9, 10, 12
//            };
//            return result[n - 1];
//        }

        PriorityQueue<Long> queue = new PriorityQueue<>();

        return (int) performFindUglyNumber(1, 1, n, queue);
    }

    private long performFindUglyNumber(long startNum, int currentIndex, int nth, PriorityQueue<Long> queue) {

        if (currentIndex == nth) {
            return startNum;
        }
        if (!queue.contains(startNum * 2)) {
            queue.add((long) (startNum * 2));
        }
        if (!queue.contains(startNum * 3)) {
            queue.add((long) (startNum * 3));
        }
        if (!queue.contains(startNum * 5)) {
            queue.add((long) (startNum * 5));
        }
        Long minInQueue = queue.poll();
        if (minInQueue != null) {

            return  performFindUglyNumber(minInQueue, currentIndex + 1, nth, queue);
        } else {
            throw new IllegalStateException("no num in queue");
        }
    }
}