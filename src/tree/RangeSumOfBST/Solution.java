package tree.RangeSumOfBST;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int rangeSumBST(TreeNode root, int leftValue, int rightValue) {

        TreePathResult lResult = new TreePathResult();
        TreePathResult rResult = new TreePathResult();
        performDFS(lResult, new ArrayList<>(), root, leftValue);
        performDFS(rResult, new ArrayList<>(), root, rightValue);

        return 0;
    }

    private void performDFS(
            TreePathResult treePathResult,
            List<TreeNode> curList,
            TreeNode root,
            int target) {

        if (treePathResult.found) {
            return;
        }

        curList.add(root);
        if (root.val == target) {
            treePathResult.found = true;
            treePathResult.path.addAll(curList);
        } else {
            curList.add(root.left);
            performDFS(treePathResult, curList, root.left, target);
            curList.remove(curList.size() - 1);

            if (!treePathResult.found) {
                curList.add(root.right);
                performDFS(treePathResult, curList, root.right, target);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private static class TreePathResult {
        List<TreeNode> path = new ArrayList<>();
        boolean found = false;
    }
}