package study.matrix.MaximalRectangle;

import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[] heightArray = new int[colCount];

        int maxArea = 0;
        Stack<Integer> heightStack = new Stack<>();
        for (int row = 0; row < rowCount; row++) {

            for (int col = 0; col < colCount; col++) {
                if (getValue(matrix[row][col]) == 0) {
                    heightArray[col] = 0;
                } else {
                    heightArray[col] = heightArray[col] + 1;
                }
            }

            for (int col = 0; col < colCount; col++) {

                while (!heightStack.isEmpty() && heightArray[heightStack.peek()] >= heightArray[col]) {

                    int j = heightStack.pop();
                    int start = heightStack.isEmpty() ? -1 : heightStack.peek();
                    int width = col - start - 1;
                    int height = heightArray[j];
                    maxArea = Math.max(maxArea, width * height);

                }

                heightStack.push(col);
            }

            while (!heightStack.isEmpty()) {

                int end = heightStack.pop();
                int start = heightStack.isEmpty() ? -1 : heightStack.peek();
                int width = heightArray.length - start - 1;
                int height = heightArray[end];
                maxArea = Math.max(maxArea, width * height);
            }

        }
        return maxArea;
    }

    private int getValue(char c) {
        if (c == '0') {
            return 0;
        } else {
            return 1;
        }
    }
}