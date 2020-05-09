package study.array.ShuffleArray;

import java.util.Arrays;
import java.util.Random;

class Solution {

    int[] originNums;

    public Solution(int[] nums) {
        originNums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(
                originNums, originNums.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = originNums.length;
        int[] res = Arrays.copyOf(originNums, originNums.length);
        boolean[] set = new boolean[len];
        for (int i = 0; i < set.length; i++) {
            set[i] = false;
        }

        Random random = new Random();

        for (int i = 0; i < originNums.length; i++) {
            int num = originNums[i];
            swap(res, i, random.nextInt(len));
        }

        return res;
    }

    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
