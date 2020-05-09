package study.search.NQueens.II;

import java.util.ArrayList;
import java.util.List;

/**
 * 所以，这个 II 其实跟 I 可以都用遍历的方法来解决。
 * leetcode 上时间也都通过了，没有 limit。
 * 是不是有非遍历的方法来解决呢？
 */
class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }

        List<List<Position>> result = performTraversal(
                new ArrayList<>(),
                new ArrayList<>(),
                n,
                n,
                0
        );
        return result.size();
    }

    private List<List<Position>> performTraversal(
            List<List<Position>> resultContainer,
            List<Position> currentList,
            int rows,
            int cols,
            int startRow
    ) {
        if (startRow == rows) {
            if (currentList.size() == rows) {
                resultContainer.add(new ArrayList<>(currentList));
            }
            return resultContainer;
        }

        for (int col = 0; col < cols; col++) {
            if (checkValid(currentList, startRow, col)) {
                currentList.add(new Position(startRow, col));
                performTraversal(resultContainer, currentList, rows, cols, startRow + 1);
                currentList.remove(currentList.size() - 1);
            }
        }

        return resultContainer;
    }

    private boolean checkValid(List<Position> cur, int row, int col) {
        for (Position position : cur) {
            if (position.x == row
                    || position.y == col
                    || Math.abs(position.x - row) == Math.abs(position.y - col)) {
                return false;
            }
        }
        return true;
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}