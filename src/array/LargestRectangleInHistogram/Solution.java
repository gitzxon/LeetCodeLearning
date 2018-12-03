package array.LargestRectangleInHistogram;

import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        while (i < heights.length) {

            if (stack.empty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i += 1;
            } else {
                int tmpArea = calAreaAndPop(heights, stack, i);
                if (maxArea < tmpArea) {
                    maxArea = tmpArea;
                }
            }
        }

        while (!stack.empty()) {
            int tmpArea = calAreaAndPop(heights, stack, i);
            if (maxArea < tmpArea) {
                maxArea = tmpArea;
            }
        }

        return maxArea;
    }

    private int calAreaAndPop(int[] heights, Stack<Integer> stack, int givenEnd) {
        Integer poppedIndex = stack.pop();
        int width;
        if (stack.empty()) {
            width = 1;
        } else {
//            int start = stack.peek() + 1;
//            int end = givenEnd - 1;
//            width = end - start + 1;
            width = givenEnd - stack.peek() - 1;
        }
        return width * heights[poppedIndex];
    }
}