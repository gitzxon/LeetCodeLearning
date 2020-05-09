package study.array.TrappingRainWater;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int left  = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int count = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(height[left], leftMax);
                count += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                count += rightMax - height[right];
                right--;
            }
        }

        return count;
    }
}