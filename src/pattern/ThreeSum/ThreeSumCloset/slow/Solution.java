package pattern.ThreeSum.ThreeSumCloset.slow;

import java.util.ArrayList;
import java.util.List;

/**
 * 超时
 */
class Solution {

    private int mTarget;
    private int mResult;
    private boolean mFoundResult;
    private int[] mNums;

    public int threeSumClosest(int[] nums, int target) {
        assert nums != null && nums.length != 0;
//        Arrays.sort(nums);
        mTarget = target;
        mNums = nums;
        mResult = Integer.MAX_VALUE;
        helper(new ArrayList<>(), 0);
        return mResult;
    }

    private void helper(List<Integer> chosenNums, int nextIndex) {
        if (chosenNums.size() > 3) {
            return;
        }
        if (chosenNums.size() == 3) {

            int sum = 0;
            for (Integer chosenNum : chosenNums) {
                sum += chosenNum;
            }
            if (!mFoundResult || Math.abs(sum - mTarget) < Math.abs(mResult - mTarget)) {
                mResult = sum;
                mFoundResult = true;
            }
        }

        for (int i = nextIndex; i < mNums.length; i++) {
            chosenNums.add(mNums[i]);
            helper(chosenNums, i + 1);
            chosenNums.remove(chosenNums.size() - 1);

        }
    }
}