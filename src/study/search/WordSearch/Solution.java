package study.search.WordSearch;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private int mRowCount;
    private int mColCount;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return false;
        }

        int rowCount = board.length;
        int colCount = board[0].length;
        mRowCount = rowCount;
        mColCount = colCount;
        boolean[][] used = new boolean[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                used[i][j] = false;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (helper(board, used, i, j, word, 1)) {
                        return true;
                    } else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }


    private boolean helper(char[][] board, boolean[][] used, int currentRow, int currentCol, String word, int nextIndex) {

        if (nextIndex >= word.length()) {
            return true;
        }

        char nextChar = word.charAt(nextIndex); // todo

        List<Coordinate> coordinatesList = new ArrayList<Coordinate>(4) {{
            add(new Coordinate());
            add(new Coordinate());
            add(new Coordinate());
            add(new Coordinate());
        }};

        coordinatesList.get(0).row = currentRow - 1;
        coordinatesList.get(0).col = currentCol;

        coordinatesList.get(1).row = currentRow;
        coordinatesList.get(1).col = currentCol + 1;

        coordinatesList.get(2).row = currentRow + 1;
        coordinatesList.get(2).col = currentCol;

        coordinatesList.get(3).row = currentRow;
        coordinatesList.get(3).col = currentCol - 1;


        for (int i = 0; i < coordinatesList.size(); i++) {
            Coordinate coordinate = coordinatesList.get(i);
            int row = coordinate.row;
            int col = coordinate.col;
            if (row >= 0 && row < mRowCount && col >= 0 && col < mColCount) {
                if (board[row][col] == nextChar && !used[row][col]) {
                    used[row][col] = true;
                    boolean result = helper(board, used, row, col, word, nextIndex + 1);
                    if (result) {
                        return true;
                    } else {
                        used[row][col] = false;
                    }
                }
            }
        }
        return false;
    }

    private class Coordinate {
        int row;
        int col;
    }
}