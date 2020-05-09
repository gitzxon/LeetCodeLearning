package study.dp.RangeSumQuery2D;

class NumMatrix {

    int[][] matrix;
    int[][] dp;
    boolean invalidMatrix = false;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        if (matrix.length == 0 || matrix[0].length == 0) {
            invalidMatrix = true;
            return;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        this.dp = new int[rowCount][colCount];

        dp[0][0] = matrix[0][0];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                dp[row][col] = initRegion(0, 0, row, col);
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (invalidMatrix) return 0;

        boolean noHorizontal = row1 == 0;
        boolean noVertical = col1 == 0;
        boolean noLeftTop = noVertical || noHorizontal;

        int horizontal;
        if (noHorizontal) {
            horizontal = 0;
        } else {
            horizontal = dp[row1 - 1][col2];
        }

        int vertical;
        if (noVertical) {
            vertical = 0;
        } else {
            vertical = dp[row2][col1 - 1];
        }

        int leftTop;
        if (noLeftTop) {
            leftTop = 0;
        } else {
            leftTop = dp[row1 - 1][col1 - 1];
        }

        return dp[row2][col2] + leftTop - horizontal - vertical;
    }

    public int initRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                result += matrix[row][col];
            }
        }
        return result;
    }
}
