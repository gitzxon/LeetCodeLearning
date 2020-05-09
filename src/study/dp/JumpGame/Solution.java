package study.dp.JumpGame;

public class Solution {

    public boolean canJump(int[] nums) {

        if (nums == null) return false;
        if (nums.length == 1) return true;

        int[] remains = new int[nums.length];
        remains[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (remains[i - 1] <= 0) {
                return false;
            }

            remains[i] = Math.max(
                    remains[i - 1] - 1,
                    nums[i]);
        }

        return remains[nums.length - 1] >= 0;
    }


}