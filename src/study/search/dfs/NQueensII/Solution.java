package study.search.dfs.NQueensII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 使用的 HashSet 来处理，所以时间一直是 6ms 7ms 8ms 这样的。
 * 但是思想是对的。
 * 用数组来处理就没有问题了。
 * todo: change hash set to boolean array
 */
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        handleNQueens(
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new ArrayList<>(),
                n, 0
        );

        return count;
    }

    private void handleNQueens(
            HashSet<Integer> colSet,
            HashSet<Integer> setForJPlusI,
            HashSet<Integer> setForJMinusI,
            List<Integer> curResult,
            int n, int row
    ) {

        if (row == n) {
            count += 1;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colSet.contains(col)) {
                continue;
            }

            int plus = row + col;
            if (setForJPlusI.contains(plus)) {
                continue;
            }

            int minus = col - row;
            if (setForJMinusI.contains(minus)) {
                continue;
            }

            colSet.add(col);
            setForJPlusI.add(plus);
            setForJMinusI.add(minus);
            curResult.add(col);
            handleNQueens(
                    colSet,
                    setForJPlusI,
                    setForJMinusI,
                    curResult,
                    n, row + 1
            );

            colSet.remove(col);
            setForJPlusI.remove(plus);
            setForJMinusI.remove(minus);
            curResult.remove(curResult.size() - 1);
        }
    }
}