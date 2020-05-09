package study.num.FindMissingNumber;

public class SolutionXor {
    public int missingNumber(int[] nums) {
        int min = 0;
        int max = nums.length;
        int xor = 0;
        for (int i = 0; i <= max; i++) {
            xor = xor ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
