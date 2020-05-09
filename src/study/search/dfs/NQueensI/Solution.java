package study.search.dfs.NQueensI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> indexListContainer = new ArrayList<>();

        handleNQueens(
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                indexListContainer,
                new ArrayList<>(),
                n, 0
        );

        List<List<String>> result = new ArrayList<>(indexListContainer.size());

        for (int i = 0; i < indexListContainer.size(); i++) {
            List<Integer> indexOneResult = indexListContainer.get(i);
            List<String> stringOneResult = new ArrayList<>(indexOneResult.size());

            for (int j = 0; j < indexOneResult.size(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    stringBuilder.append(".");
                }
                stringBuilder.setCharAt(indexOneResult.get(j), 'Q');
                stringOneResult.add(stringBuilder.toString());
            }
            result.add(stringOneResult);
        }

        return result;
    }

    private void handleNQueens(
            HashSet<Integer> colSet,
            HashSet<Integer> setForJPlusI,
            HashSet<Integer> setForJMinusI,
            List<List<Integer>> resultContainer,
            List<Integer> curResult,
            int n, int row
    ) {

        if (row == n) {
            resultContainer.add(new ArrayList<>(curResult));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colSet.contains(col)) {
                continue;
            }

            if (setForJPlusI.contains(row + col)) {
                continue;
            }

            if (setForJMinusI.contains(col - row)) {
                continue;
            }

            colSet.add(col);
            setForJPlusI.add(row + col);
            setForJMinusI.add(col - row);
            curResult.add(col);
            handleNQueens(
                    colSet,
                    setForJPlusI,
                    setForJMinusI,
                    resultContainer,
                    curResult,
                    n, row + 1
            );

            colSet.remove(col);
            setForJPlusI.remove(row + col);
            setForJMinusI.remove(col - row);
            curResult.remove(curResult.size() - 1);
        }
    }
}