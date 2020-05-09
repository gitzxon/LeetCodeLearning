package study.search.WordSearchII;

import java.util.*;

class Solution {

    char[][] mBoard;
    boolean[][] mVisited;
    int mRowCount;
    int mColCount;
    Set<String> mWords;
    List<String> mResultContainer;

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }

        mBoard = board;
        mRowCount = board.length;
        mColCount = board[0].length;
        mVisited = new boolean[mRowCount][mColCount];

        mWords = new HashSet<>();
        mWords.addAll(Arrays.asList(words));
        mResultContainer = new ArrayList<>();

        HashMap<Character, List<Point>> characterToPositionHashMap = new HashMap<>();
        for (int i = 0; i < mRowCount; i++) {
            for (int j = 0; j < mColCount; j++) {
                List<Point> list;
                if (characterToPositionHashMap.containsKey(board[i][j])) {
                    list = characterToPositionHashMap.get(board[i][j]);
                } else {
                    list = new ArrayList<>();
                }
                list.add(new Point(i, j));
                characterToPositionHashMap.put(board[i][j], list);
            }
        }

        for (String word : mWords) {
            char c = word.charAt(0);
            List<Point> points = characterToPositionHashMap.get(c);
            if (points == null) {
                continue;
            }
            for (Point point : points) {
                boolean result = helper(word, 0, point.row, point.col);
                if (result) {
                    mResultContainer.add(word);
                    break;
                }
            }
        }
        return mResultContainer;
    }

    private boolean helper(String word, int startIndex, int startRow, int startCol) {
        if (!(startIndex >= 0 && startIndex < word.length()
                && startRow >= 0 && startRow < mRowCount
                && startCol >= 0 && startCol < mColCount)) {
            return false;
        }

        if (mVisited[startRow][startCol]) {
            return false;
        }

        if (word.charAt(startIndex) == mBoard[startRow][startCol]) {
            mVisited[startRow][startCol] = true;
            if (startIndex == word.length() - 1) {
                mVisited[startRow][startCol] = false;
                return true;
            }
            int nextIndex = startIndex + 1;

            boolean top = helper(word, nextIndex, startRow, startCol - 1);
            boolean right = helper(word, nextIndex, startRow + 1, startCol);
            boolean bottom = helper(word, nextIndex, startRow, startCol + 1);
            boolean left = helper(word, nextIndex, startRow - 1, startCol);

            boolean result = top || right || bottom || left;
            mVisited[startRow][startCol] = false;
            return result;
        } else {
            return false;
        }
    }

    private class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(row) + Integer.hashCode(col);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Point && ((Point) obj).col == col && ((Point) obj).row == row;
        }
    }
}