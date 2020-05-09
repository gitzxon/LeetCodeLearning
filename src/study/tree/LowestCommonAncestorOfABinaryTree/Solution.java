package study.tree.LowestCommonAncestorOfABinaryTree;

import study.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> path1 = dfs(new ArrayList<>(), root, p);
        List<TreeNode> path2 = dfs(new ArrayList<>(), root, q);
        if (path1 == null || path2 == null) {
            // should not be null
            return null;
        }

        TreeNode pre = null;
        int i = 0;
        while (i >= 0 && i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            pre = path1.get(i);
            i += 1;
        }

        System.out.println("pre.val = " + pre.val);
        return pre;
    }

    private List<TreeNode> dfs(List<TreeNode> resultContainer, TreeNode start, TreeNode end) {
        if (start == end) {
            resultContainer.add(start);
            return new ArrayList<>(resultContainer);
        }

        if (start == null) {
            return null;
        }

        if (start.left == null && start.right == null) {
            return null;
        }

        if (start.left != null) {
            resultContainer.add(start);
            List<TreeNode> result = dfs(resultContainer, start.left, end);
            if (result == null) {
                resultContainer.remove(resultContainer.size() - 1);
            } else {
                return result;
            }
        }

        if (start.right != null) {
            resultContainer.add(start);
            List<TreeNode> result = dfs(resultContainer, start.right, end);
            if (result == null) {
                resultContainer.remove(resultContainer.size() - 1);
            } else {
                return result;
            }
        }

        return null;

    }
}