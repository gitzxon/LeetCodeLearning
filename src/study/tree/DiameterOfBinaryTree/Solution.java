package study.tree.DiameterOfBinaryTree;

import study.tree.TreeNode;

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
    int maxCount = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        performCalculateDiameterOfBinaryTree(root);
        return maxCount - 1;
    }

    private int performCalculateDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            maxCount = Math.max(maxCount, 0);
            return 0;
        }

        if (root.left == null && root.right == null) {
            maxCount = Math.max(maxCount, 1);
            return 1;
        }

        int left = performCalculateDiameterOfBinaryTree(root.left);
        int right = performCalculateDiameterOfBinaryTree(root.right);
        maxCount = Math.max(maxCount, left + right + 1);

        return Math.max(left, right) + 1;
    }
}