package tree.ValidateBinarySearchTree;

import tree.TreeNode;

class Solution {


    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode currentNode, long min, long max) {
        if (currentNode == null) {
            return true;
        }

        if (currentNode.left != null && currentNode.left.value >= currentNode.value) {
            return false;
        }

        if (currentNode.right != null && currentNode.right.value <= currentNode.value) {
            return false;
        }

        if (currentNode.value <= min) {
            return false;
        }

        if (currentNode.value >= max) {
            return false;
        }

        long newMin = Math.max(currentNode.value, min);
        long newMax = Math.min(currentNode.value, max);

        boolean left = helper(currentNode.left, min, newMax);
        boolean right = helper(currentNode.right, newMin, max);
        return left && right;
    }
}