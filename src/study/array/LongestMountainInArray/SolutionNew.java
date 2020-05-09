package study.array.LongestMountainInArray;

public class SolutionNew {

    public int longestMountain(int[] nums) {
        int len = 0;
        int up = 0;
        int down = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                up = 0;
                down = 0;
            } else if (nums[i] > nums[i - 1]) {
                if (down != 0) {
                    down = 0;
                    up = 0;
                }
                up++;
            } else if (nums[i] < nums[i - 1]) {
                down++;
            }

            if (up > 0 && down > 0 && up + down + 1 > len) {
                len = up + down + 1;
            }

        }

        return len;
    }
}


