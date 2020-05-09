package study.search.WordInMatrix;

/**
 * https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows == 0 || cols == 0 || str.length == 0) {
            return false;
        }
        boolean result = false;

        boolean[] accessed = new boolean[matrix.length];
        for (int i = 0; i < accessed.length; i++) {
            accessed[i] = false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = result || performHasPath(
                        matrix, accessed,
                        rows, cols,
                        i, j, str, 0);
            }
        }

        return result;
    }

    private boolean performHasPath(
            char[] matrix, boolean[] accessed,
            int rows, int cols,
            int curRow, int curCol,
            char[] str, int tail) {

        if (tail >= str.length) {
            return true;
        }

        if (curRow >= rows
                || curCol >= cols
                || curRow < 0 || curCol < 0) {
            return false;
        }

        int position = curRow * cols + curCol;
        if (accessed[position]) {
            return false;
        }

        if (matrix[position] == str[tail]) {
            accessed[position] = true;
            boolean right = performHasPath(
                    matrix, accessed,
                    rows, cols,
                    curRow, curCol + 1,
                    str, tail + 1
            );

            boolean bottom = performHasPath(
                    matrix, accessed,
                    rows, cols,
                    curRow + 1, curCol,
                    str, tail + 1
            );

            boolean left = performHasPath(
                    matrix, accessed,
                    rows, cols,
                    curRow, curCol - 1,
                    str, tail + 1
            );

            boolean top = performHasPath(
                    matrix, accessed,
                    rows, cols,
                    curRow - 1, curCol,
                    str, tail + 1
            );

            accessed[position] = false;

            return right || bottom || left || top;
        } else {
            return false;
        }
    }
}