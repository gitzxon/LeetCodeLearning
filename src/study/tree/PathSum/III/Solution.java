package study.tree.PathSum.III;

import study.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public int pathSum(TreeNode root, int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return performPathSum(
                root, 0,
                sum, map
        );
    }

    private int performPathSum(
            final TreeNode root,
            final int curSum, final int targetSum,
            final Map<Integer, Integer> map) {

        if (root == null) {
            return 0;
        }

        int value = root.val;
        int result = 0;

        int tmpCurSum = curSum + value;
        result += map.getOrDefault(tmpCurSum - targetSum, 0);

        map.put(tmpCurSum, map.getOrDefault(tmpCurSum, 0) + 1);

        int left = performPathSum(
                root.left, tmpCurSum, targetSum, map
        );

        int right = performPathSum(
                root.right, tmpCurSum, targetSum, map
        );

        map.put(tmpCurSum, map.getOrDefault(tmpCurSum, 1) - 1);
        return result + left + right;
    }

}