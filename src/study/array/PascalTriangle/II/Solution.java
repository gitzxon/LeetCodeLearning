package study.array.PascalTriangle.II;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> getRow(int rowIndex) {

        int[] array = new int[rowIndex + 1];
        for (int row = 0; row <= rowIndex; row++) {
            for (int i = row; i >= 0; i--) {
                if (i == row || i == 0) {
                    array[i] = 1;
                } else {
                    array[i] = array[i] + array[i - 1];
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            res.add(array[i]);
        }
        return res;
    }


    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList();
        }


        List<Integer> r0 = new ArrayList<>();
        r0.add(1);
        if (rowIndex == 0) return r0;


        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(1);
        if (rowIndex == 1) return r1;

        List<Integer> pre = r1;
        List<Integer> cur = r0;
        for (int i = 2; i <= rowIndex; i++) {

            cur.clear();
            for (int j = 0; j < pre.size() + 1; j++) {
                if (j == 0 || j == pre.size()) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            List<Integer> tmp = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}