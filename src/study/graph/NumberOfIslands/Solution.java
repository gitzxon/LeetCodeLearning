package study.graph.NumberOfIslands;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowCount = grid.length;
        int colCount = grid[0].length;
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '1') {
                    exploreDFS(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void exploreDFS(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length
                && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == '1') {
                grid[i][j] = 'x';
                exploreDFS(grid, i - 1, j);
                exploreDFS(grid, i + 1, j);
                exploreDFS(grid, i, j - 1);
                exploreDFS(grid, i, j + 1);
            }
        }
    }
}