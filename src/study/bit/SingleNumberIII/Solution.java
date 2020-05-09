package study.bit.SingleNumberIII;

class Solution {
    public int[] singleNumber(int[] nums) {

        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff = nums[i] ^ diff;
        }

        int rightMost1 = (diff & -diff);
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightMost1) == rightMost1) {
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }
}
