package study.tree.PathSum.II;

import study.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<TreeNode>> resultContainer = new ArrayList<>();
        performTraversal(
                root,
                new ArrayList<>(),
                0, sum,
                resultContainer
        );

        List<List<Integer>> result = new ArrayList<>(resultContainer.size());
        for (int i = 0; i < resultContainer.size(); i++) {
            List<TreeNode> treeNodeList = resultContainer.get(i);
            List<Integer> list = new ArrayList<>(treeNodeList.size());
            for (int j = 0; j < treeNodeList.size(); j++) {
                list.add(treeNodeList.get(j).val);
            }
            result.add(list);
        }

        return result;
    }

    private void performTraversal(
            TreeNode root,
            List<TreeNode> currentList,
            int curSum,
            int targetSum,
            List<List<TreeNode>> resultContainer
    ) {

        if (root == null) {
            return;
        }

        currentList.add(root);
        curSum += root.val;

        if (curSum == targetSum && root.left == null && root.right == null) {
            resultContainer.add(new ArrayList<>(currentList));
        }

        performTraversal(
                root.left,
                currentList,
                curSum,
                targetSum,
                resultContainer);

        performTraversal(
                root.right,
                currentList,
                curSum,
                targetSum,
                resultContainer);
        currentList.remove(currentList.size() - 1);

    }
}