package study.dp.UniquePathBundle.UniquePathII;

import java.util.Arrays;

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0;

        int rowCount = obstacleGrid.length;
        int colCount = obstacleGrid[0].length;

        int[][] matrix = new int[rowCount][colCount];
        matrix[0][0] = 1;

        for (int i = 1; i < colCount; i++) {
            if (obstacleGrid[0][i] == 1 || obstacleGrid[0][i - 1] == 1) {
                matrix[0][i] = 0;
            } else {
                matrix[0][i] = matrix[0][i - 1];
            }
        }

        for (int i = 1; i < rowCount; i++) {
            if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == 1) {
                matrix[i][0] = 0;
            } else {
                matrix[i][0] = matrix[i - 1][0];
            }
        }

        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {

                if (obstacleGrid[row][col] == 1) {
                    matrix[row][col] = 0;
                    continue;
                }

                if (obstacleGrid[row][col - 1] == 1) {
                    matrix[row][col] = matrix[row - 1][col];
                    continue;
                }

                if (obstacleGrid[row - 1][col] == 1) {
                    matrix[row][col] = matrix[row][col - 1];
                    continue;
                }

                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix[rowCount - 1][colCount - 1];
    }
}