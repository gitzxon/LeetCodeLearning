package study.hulu.SumOfOther;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个正整数组a，返回一个新的数组sums，满足sums[i]的值为正整数组a中比a[i]小的数字之和；如果不存在比a[i]小的数字，则sums[i]为0。
 * 已知数组a中元素最大值不超过100000，数组长度不超过10000，数组元素允许重复。
 * hulu 往届校招第一题
 */
public class Solution {

    public int[] calculate(int[] nums) {

        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        Arrays.sort(newNums);
        int[] result = new int[nums.length];

        HashMap<Integer, Integer> cache = new HashMap<>();
        int preCount = 1;
        int i = 0;

        while (i < newNums.length) {

            if (i == 0) {
                cache.put(newNums[i], 0);
            } else {

                while (newNums[i] == newNums[i - 1]) {
                    preCount++;
                    i++;
                }


                cache.put(newNums[i], cache.get(newNums[i - 1]) + preCount * newNums[i - 1]);

            }

            preCount = 1;
            i++;
        }

        for (int j = 0; j < result.length; j++) {
            result[j] = cache.getOrDefault(nums[j], 0);
        }

        return result;

    }
}
