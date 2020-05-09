package study.array.CircularArrayLoop;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        List<Integer> headCandicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i + n < 0 || i + n > nums.length - 1) {
                headCandicates.add(i);
            }
        }

        for (int i = 0; i < headCandicates.size(); i++) {
            if (doublePointerCircularCheck(nums, headCandicates.get(i))) {
                return true;
            }
        }

        return false;
    }

    public boolean doublePointerCircularCheck(int[] nums, int head) {
        int fast = head;
        int slow = head;

        boolean changeDirection = false;

        do {
            int originDirection;
            int newDirection;
            slow = findNext(nums, slow);

            originDirection = nums[fast];
            fast = findNext(nums, fast);
            newDirection = nums[fast];
            if (newDirection * originDirection < 0) changeDirection = true;

            originDirection = nums[fast];
            fast = findNext(nums, fast);
            newDirection = nums[fast];
            if (newDirection * originDirection < 0) changeDirection = true;

        } while (slow != fast && !changeDirection);

        if (changeDirection || fast == findNext(nums, fast)) {
            return false;
        } else {
            return true;
        }

    }

    private int findNext(int[] nums, int index) {
        index = (index + nums[index] + nums.length) % nums.length;
        return index;
    }
}