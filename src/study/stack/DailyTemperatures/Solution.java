package study.stack.DailyTemperatures;

import java.util.Stack;

class Solution {

    public int[] dailyTemperatures(int[] tempratures) {

        if (tempratures == null || tempratures.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        int[] right = new int[tempratures.length];

        for (int i = 0; i < tempratures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (tempratures[stack.peek()] < tempratures[i]) {
                    while (!stack.isEmpty() && tempratures[stack.peek()] < tempratures[i]) {
                        int index = stack.pop();
                        right[index] = i - index;
                    }

                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            right[index] = 0;
        }

        return right;
    }

}