package study.array.Permutation.PermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * dfs
 */
public class SolutionNew {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        return helper(new ArrayList<>(), nums, used, new ArrayList<>(nums.length));

    }

    public List<List<Integer>> helper(List<List<Integer>> permutationContainer, int[] nums, boolean[] used, List<Integer> curList) {
        if (curList.size() == nums.length) {
            permutationContainer.add(new ArrayList<>(curList));
            System.out.println("permutationContainer = " + permutationContainer);
            return permutationContainer;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            curList.add(nums[i]);
            used[i] = true;
            helper(permutationContainer, nums, used, curList);
            curList.remove(curList.size() - 1);
            used[i] = false;
        }

        return permutationContainer;
    }


}
