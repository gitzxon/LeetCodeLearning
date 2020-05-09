package study.array.FirstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }

        if (min != 1) {
            return 1;
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0) {
                i += 1;
            } else {
                int indexToSwap = nums[i] - 1;

                if (indexToSwap != i && indexToSwap <= nums.length - 1) {

                    if (nums[indexToSwap] != nums[i]) {
                        swap(nums, i, indexToSwap);
                    } else {
                        i += 1;
                    }

                } else {
                    i += 1;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}