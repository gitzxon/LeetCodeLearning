package study.tree.MaximumDepthOfBinaryTree;

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
    public int maxDepth(TreeNode root) {
        return performTraversal(root, 0, 0);
    }

    private int performTraversal(TreeNode root, int currentDepth, int maxDepth) {
        if (root == null) {
            return maxDepth;
        }

        int localCurrentDepth = currentDepth + 1;
        int localMax = maxDepth;
        if (localCurrentDepth > maxDepth) {
            localMax = localCurrentDepth;
        }
        int leftMaxDepth = performTraversal(root.left, localCurrentDepth, localMax);
        int rightMaxDepth = performTraversal(root.right, localCurrentDepth, localMax);
        return Math.max(leftMaxDepth, rightMaxDepth);
    }
}