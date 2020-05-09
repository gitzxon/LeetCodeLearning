package study.array.PancakeSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int count = nums.length;

        int[] expected = new int[count];
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i + 1;
            valueToIndex.put(i + 1, i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int currentIndex = valueToIndex.get(nums[i]);
            // from currentIndex to i
            if (currentIndex != i) {
                reverse(expected, currentIndex, valueToIndex);
                reverse(expected, i, valueToIndex);
                if (currentIndex != 0) {
                    stack.push(currentIndex + 1);
                }
                stack.push(i + 1);
            }
        }

        while (stack.size() != 0) {
            stack.peek();
            resultList.add(stack.pop());
        }
        return resultList;
    }

    private void reverse(int[] nums, int endIndex, HashMap<Integer, Integer> valueToIndexMap) {
        for (int i = 0; i <= endIndex / 2; i++) {
            int value1 = nums[i];
            int value2 = nums[endIndex - i];
            int index1 = i;
            int index2 = endIndex - i;
            swap(nums, index1, index2);
            valueToIndexMap.put(value1, index2);
            valueToIndexMap.put(value2, index1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}