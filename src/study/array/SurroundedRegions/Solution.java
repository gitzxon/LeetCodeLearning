package study.array.SurroundedRegions;


class Solution {

    char[][] mBoard;
    int mRowCount;
    int mColCount;

    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }

        mBoard = board;
        mRowCount = board.length;
        mColCount = board[0].length;

        for (int i = 0; i < mRowCount; i++) {
            explore(i, 0);
            explore(i, mColCount - 1);
        }

        for (int i = 0; i < mColCount; i++) {
            explore(0, i);
            explore(mRowCount - 1, i);
        }

        for (int i = 0; i < mRowCount; i++) {
            for (int j = 0; j < mColCount; j++) {
                if (mBoard[i][j] != '-') {
                    mBoard[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < mRowCount; i++) {
            for (int j = 0; j < mColCount; j++) {
                if (mBoard[i][j] == '-') {
                    mBoard[i][j] = 'O';
                }
            }
        }
    }

    private void explore(int row, int col) {

        if (!(row >= 0 && row < mRowCount
                && col >= 0 && col < mColCount)) {
            return;
        }

        if (mBoard[row][col] == 'O') {
            mBoard[row][col] = '-';
            explore(row - 1, col);
            explore(row, col + 1);
            explore(row + 1, col);
            explore(row, col - 1);
        }

    }
}