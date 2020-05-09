package study.array.FindMedianFromDataStream;

import java.util.PriorityQueue;

class MedianFinder {

    /**
     * nums smaller than median
     * big to small from top to bottom
     */
    PriorityQueue<Integer> smallQueue;

    /**
     * nums bigger than median
     * small to big from top to bottom
     */
    PriorityQueue<Integer> bigQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        smallQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        bigQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        bigQueue.add(num);
        if (bigQueue.size() - smallQueue.size() >= 2) {
            smallQueue.add(bigQueue.poll());
        }

        if (!smallQueue.isEmpty() && !bigQueue.isEmpty() && bigQueue.peek() < smallQueue.peek()) {
            Integer big = bigQueue.poll();
            Integer small = smallQueue.poll();
            bigQueue.add(small);
            smallQueue.add(big);
        }
    }

    public double findMedian() {
        if (bigQueue.isEmpty() && smallQueue.isEmpty()) {
            return 0;
        } else if (bigQueue.isEmpty()) {
            return smallQueue.peek();
        } else if (smallQueue.isEmpty()) {
            return bigQueue.peek();
        }

        if (bigQueue.size() == smallQueue.size()) {
            Double big = Double.valueOf(bigQueue.peek());
            Double small = Double.valueOf(smallQueue.peek());
            return (big + small) / 2;
        } else {
            return Double.valueOf(bigQueue.peek());
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */