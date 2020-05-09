package study.tree.ValidateBinarySearchTree;

import study.tree.TreeNode;

class Solution {


    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode currentNode, long min, long max) {
        if (currentNode == null) {
            return true;
        }

        if (currentNode.left != null && currentNode.left.val >= currentNode.val) {
            return false;
        }

        if (currentNode.right != null && currentNode.right.val <= currentNode.val) {
            return false;
        }

        if (currentNode.val <= min) {
            return false;
        }

        if (currentNode.val >= max) {
            return false;
        }

        long newMin = Math.max(currentNode.val, min);
        long newMax = Math.min(currentNode.val, max);

        boolean left = helper(currentNode.left, min, newMax);
        boolean right = helper(currentNode.right, newMin, max);
        return left && right;
    }
}