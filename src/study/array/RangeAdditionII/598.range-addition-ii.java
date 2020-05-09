/*
 * @lc app=leetcode id=598 lang=java
 *
 * [598] Range Addition II
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
    
        int currentRow = n;
        int currentCol = m;
        for (int i = 0; i < ops.length; i++) {
            int col = ops[i][0];
            int row = ops[i][1];

            currentRow = Math.min(row, currentRow);
            currentCol = Math.min(col, currentCol);
        }

        System.out.println(currentRow);
        System.out.println(currentCol);
        return currentRow * currentCol;
    }
}

