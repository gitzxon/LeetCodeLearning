package study.array.PascalTriangle.I;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>(numRows);

        List<Integer> row0 = new ArrayList<>();
        row0.add(1);

        result.add(row0);
        if (numRows == 1) {
            return result;
        }

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);

        result.add(row1);
        if (numRows == 2) {
            return result;
        }


        for (int i = 2; i < numRows; i++) {
            List<Integer> pre = result.get(result.size() - 1);
            List<Integer> cur = new ArrayList<>(pre.size() + 1);
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            result.add(cur);
        }

        return result;
    }
}