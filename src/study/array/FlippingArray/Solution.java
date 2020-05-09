package study.array.FlippingArray;

class Solution {
    public int[][] flipAndInvertImage(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i < rowCount; i++) {

            for (int j = 0; j < colCount / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][colCount - 1 - j];
                matrix[i][colCount - 1 - j] = tmp;
            }

            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                }
            }
        }

        return matrix;
    }
}