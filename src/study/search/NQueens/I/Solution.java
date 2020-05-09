package study.search.NQueens.I;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<Position>> result = performTraversal(
                new ArrayList<>(),
                new ArrayList<>(),
                n,
                n,
                0
        );

        List<List<String>> formattedResult = new ArrayList<>(result.size());
        for (List<Position> positions : result) {
            List<String> row = new ArrayList<>();
            for (Position position : positions) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                stringBuilder.setCharAt(position.y, 'Q');
                row.add(stringBuilder.toString());
            }
            formattedResult.add(row);
        }

        return formattedResult;
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