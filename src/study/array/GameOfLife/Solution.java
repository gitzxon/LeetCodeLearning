package study.array.GameOfLife;

import java.util.Arrays;

/**
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * <p>
 * <2 die
 * 2, 3 live
 * > 3 die
 * =3 repro
 */
class Solution {

    private static final int MASK_OLD_STATE = 1<<1;
    private static final int MASK_NEW_STATE = 1;

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = combineState(board[i][j], 0);
            }
        }

        System.out.println(Arrays.deepToString(board));

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int oldState = getOldState(board[i][j]);
                int newState = calculateNewState(board, i, j);
                board[i][j] = combineState(oldState, newState);
            }
        }

        System.out.println(Arrays.deepToString(board));

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getNewState(board[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(board));
    }

    private int calculateNewState(int[][] board, int row, int col) {
        int rowCount = board.length;
        int colCount = board[0].length;

        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i < 0 || j < 0 || i >= rowCount || j >= colCount) {
                    continue;
                }

                if (i == row && j == col) {
                    continue;
                }

                if (getOldState(board[i][j]) == 1) {
                    count += 1;
                }
            }
        }

        if (count < 2) {
            return 0;
        } else if (count == 2) {
            return getOldState(board[row][col]);
        } else if (count == 3) {
            return 1;
        } else { // > 3
            return 0;
        }
    }

    private int getOldState(int a) {
        return (a & MASK_OLD_STATE) >>> 1;
    }

    private int getNewState(int a) {
        return a & MASK_NEW_STATE;
    }

    private int combineState(int oldState, int newState) {
        return (oldState << 1) + newState;
    }
}