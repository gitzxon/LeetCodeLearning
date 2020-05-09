package study.array.KthSmallestElementInASortedMatrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 还可以提示。
 * 比如一个 row 里面用 二分查找，估计能大幅度降低时间。
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        List<Integer> colIndexList = new ArrayList<Integer>(matrix.length);

        for (int i = 0; i < rowCount; i++) {
            colIndexList.add(0);
        }

        PriorityQueue<ValueWithRowIndex> priorityQueue = new PriorityQueue<>(new Comparator<ValueWithRowIndex>() {
            @Override
            public int compare(ValueWithRowIndex o1, ValueWithRowIndex o2) {
                return o1.value - o2.value;
            }
        });

        IntStream.range(0, colIndexList.size()).forEach(index->{
            int row = index;
            int col = colIndexList.get(index);
            ValueWithRowIndex valueWithRowIndex = new ValueWithRowIndex(matrix[row][col], row);
            priorityQueue.add(valueWithRowIndex);
        });

        ValueWithRowIndex result = null;
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
            int row = result.rowIndex;
            int curCol = colIndexList.get(row);
            int nextCol = curCol + 1;
            if (nextCol >= colCount) {
                nextCol = -1;
            }
            colIndexList.set(row, nextCol);
            if (nextCol != -1) {
                ValueWithRowIndex newValue = new ValueWithRowIndex(matrix[row][nextCol], row);
                priorityQueue.add(newValue);
            }
        }

        return result.value;
    }

    class ValueWithRowIndex {
        int value;
        int rowIndex;

        public ValueWithRowIndex(int value, int rowIndex) {
            this.value = value;
            this.rowIndex = rowIndex;
        }
    }
}
