package study.array.SearchA2DMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        while (row >= 0 && row < rowCount && col >= 0 && col < colCount) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col -= 1;
            } else {
                row += 1;
            }
        }
        return false;
    }
}