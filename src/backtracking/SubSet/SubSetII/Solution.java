package backtracking.SubSet.SubSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new ArrayList<>(), 0);
    }

    private List<List<Integer>> helper(int[] nums, List<List<Integer>> resultContainer, List<Integer> currentUsedList, int startIndex) {


        for (int i = ; i < nums.length; i++) {

        }


    }
}