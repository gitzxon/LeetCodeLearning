package study.array.SpiralMatrix.II;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int times = (n + 1) / 2;
        int nextNum = 1;
        for (int i = 0; i < times; i++) {
            fillOneCircle(nums, i, i, n - 1 - i, n - 1 - i, nextNum);
            nextNum = nextNum + ((n - i - i) * 4 - 4);
        }

        return nums;
    }

    private void fillOneCircle(int[][] nums, int startRow, int startCol, int endRow, int endCol, int nextNum) {
        if (startRow == endRow && startCol == endCol) {
            nums[startRow][startCol] = nextNum;
            return;
        }
        int curNum = nextNum;
        for (int i = startCol; i < endCol; i++) {
            nums[startRow][i] = curNum;
            curNum++;
        }

        for (int i = startRow; i < endRow; i++) {
            nums[i][endCol] = curNum;
            curNum++;
        }

        for (int i = endCol; i > startCol; i--) {
            nums[endRow][i] = curNum;
            curNum++;
        }

        for (int i = endRow; i > startRow; i--) {
            nums[i][startCol] = curNum;
            curNum++;
        }
    }
}