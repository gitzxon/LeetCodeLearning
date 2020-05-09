package study.tree.LongestUnivaluePath;


import study.tree.TreeNode;

class Solution {

    int maxLength = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        maxPathLengthContainingRoot(root);

            return maxLength - 1;

    }

    private int maxPathLengthContainingRoot(TreeNode root) {
        if (root == null) {
            maxLength = Math.max(0, maxLength);
            return 0;
        }

        if (root.left == null && root.right == null) {
            maxLength = Math.max(1, maxLength);
            return 1;
        }

        int left = maxPathLengthContainingRoot(root.left);
        int right = maxPathLengthContainingRoot(root.right);
        int result = 1;
        if (root.left != null) {
            if (root.left.val == root.val) {
                result = Math.max(result, left + 1);
            }
        }

        if (root.right != null) {
            if (root.right.val == root.val) {
                result = Math.max(result, right + 1);
            }
        }

        if (root.left != null && root.right != null
                && root.left.val == root.right.val
                && root.left.val == root.val) {
            maxLength = Math.max(left + right + 1, maxLength);
        }

        maxLength = Math.max(result, maxLength);
        return result;
    }
}