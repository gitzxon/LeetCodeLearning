package study.AllTemplate.ThreeSum.ThreeSum.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resultContainer = new ArrayList<>();
        int mid;
        int right;
        for (int left = 0; left <= nums.length - 2 && nums[left] <= 0; left++) {

            if (left >= 1 && nums[left] == nums[left - 1]) {
                continue;
            }

            mid = left + 1;
            right = nums.length - 1;

            int remain = 0 - nums[left];
            while (mid < right) {
                int sum = nums[mid] + nums[right];
                if (sum == remain) {
                    addResult(resultContainer, nums[left], nums[mid], nums[right]);
                    while (validIndex(nums.length, mid)
                            && validIndex(nums.length, mid + 1)
                            && nums[mid] == nums[mid + 1]) {
                        mid += 1;
                    }
                    mid += 1;

                    while (validIndex(nums.length, right)
                            && validIndex(nums.length, right - 1)
                            && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    right -= 1;

                } else if (sum < remain) {
                    mid += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return resultContainer;
    }

    private boolean validIndex(int len, int index) {
        return index >= 0 && index < len;
    }

    private void addResult(List<List<Integer>> list, int left, int mid, int right) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(left);
        tmp.add(mid);
        tmp.add(right);
        list.add(tmp);
    }
}