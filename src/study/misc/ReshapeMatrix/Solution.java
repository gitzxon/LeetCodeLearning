package study.misc.ReshapeMatrix;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null
                || nums.length == 0
                || nums[0].length == 0) {
            return nums;
        }

        int rowCount = nums.length;
        int colCount = nums[0].length;

        if (rowCount * colCount != r * c) {
            return nums;
        }

        int currentRow = 0;
        int currentCol = 0;

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {

                result[i][j] = nums[currentRow][currentCol];

                if (currentCol == colCount - 1) {
                    currentCol = 0;
                    currentRow +=1;
                } else {
                    currentCol +=1;
                }

            }

        }

        return result;
    }
}