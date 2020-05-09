package study.dp.UniquePathBundle.UniquePathI;

class Solution {
    public int uniquePaths(int colCount, int rowCount) {

        if (colCount == 1 || rowCount == 1) {
            return 1;
        }

        int[][] matrix = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 0; i < colCount; i++) {
            matrix[0][i] = 1;
        }

        int row = 1;
        int col = 1;
        while (row < rowCount) {

            col = 1;
            while (col < colCount) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
                col += 1;
            }

            row += 1;
        }
        return matrix[rowCount - 1][colCount - 1];
    }
}