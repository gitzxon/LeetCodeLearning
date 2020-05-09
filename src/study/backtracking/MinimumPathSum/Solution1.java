package study.backtracking.MinimumPathSum;

/**
 * 60/61 passed
 * Time Limit Exceeded
 */
class Solution1 {

    private long minSum = Long.MAX_VALUE;
    private int[][] grid;
    private int rowCount;
    private int colCount;

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        rowCount = grid.length;
        colCount = grid[0].length;

        traversal(
                0,
                0,
                0
        );
        return (int) minSum;
    }

    private long traversal(
            int curRow,
            int curCol,
            int curSum
    ) {

        if (curRow >= rowCount) {
            return minSum;
        }

        if (curCol >= colCount) {
            return minSum;
        }

        int curNum = grid[curRow][curCol];
        int newSum = curSum + curNum;

        if (newSum >= minSum) {
            return minSum;
        }

        if (curRow == rowCount - 1 && curCol == colCount - 1) {
            minSum = Math.min(minSum, newSum);
        } else {

            traversal(
                    curRow,
                    curCol + 1,
                    newSum
            );

            traversal(
                    curRow + 1,
                    curCol,
                    newSum
            );
        }
        return minSum;
    }
}