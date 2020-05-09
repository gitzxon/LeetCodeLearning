package study.array.ContainerWithMostWater;

class Solution {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int low = 0;
        int high = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (low < high) {

            int curMax = Math.min(height[low], height[high]) * (high - low);
            if (max < curMax) {
                max = max = curMax;
            }

            if (height[low] <= height[high]) {
                low += 1;
            } else {
                high -= 1;
            }
        }

        return max;
    }



    /**
     * 超时了。n^2 的时间，不超时才怪。
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        int rowCount = height.length;
        int colCount = height.length;
        int[][] matrix = new int[rowCount][colCount];


        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rowCount; i++) {

            for (int j = i; j < colCount; j++) {
                if (j == i) continue;
                matrix[i][j] = (j - i) * Math.min(height[i], height[j]);
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }
}