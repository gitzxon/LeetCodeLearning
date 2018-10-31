package tree.ValidateBinarySearchTree;

import tree.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(null, root);
    }

    private boolean helper(TreeNode parentNode, TreeNode currentNode) {
        if (currentNode == null) {
            return true;
        }

        if (currentNode.left != null && currentNode.left.val >= currentNode.val) {
            return false;
        }

        if (currentNode.right != null && currentNode.right.val <= currentNode.val) {
            return false;
        }

        if (parentNode != null) {
            if (parentNode.right == currentNode) {
                if (currentNode.left != null && currentNode.left.val <= parentNode.val) {
                    return false;
                }
            } else {
                if (currentNode.right != null && currentNode.right.val >= parentNode.val) {
                    return false;
                }
            }
        }

        boolean left = helper(currentNode, currentNode.left);
        boolean right = helper(currentNode, currentNode.right);
        return left && right;
    }
}