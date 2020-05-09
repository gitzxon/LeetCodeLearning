package study.backtracking.LongestIncreasingPathInAMatrix;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private final int[][] direction = new int[][]{
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
    };

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                queue.offer(new int[]{i, j, matrix[i][j]});
            }
        }

        int[][] dp = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                dp[i][j] = 1;
            }
        }

        while (queue.size() != 0) {
            int[] item = queue.poll();
            int row = item[0];
            int col = item[1];
            for (int dir = 0; dir < direction.length; dir++) {
                int newRow = row + direction[dir][0];
                int newCol = col + direction[dir][1];
                if (newRow < 0 || newRow >= rowCount
                        || newCol < 0 || newCol >= colCount
                        || matrix[newRow][newCol] <= matrix[row][col]) {
                    continue;
                }

                dp[row][col] = Math.max(
                        dp[row][col],
                        dp[newRow][newCol] + 1
                );

            }
        }

        int maxLength = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}