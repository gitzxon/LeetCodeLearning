package array.KthSmallestElementInASortedMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        List<Integer> indexList = new ArrayList<Integer>(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            indexList.add(0);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        int res = Integer.MAX_VALUE;
        while (true) {
        }
    }
}
