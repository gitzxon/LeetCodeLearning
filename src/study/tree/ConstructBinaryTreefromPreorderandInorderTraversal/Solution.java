package study.tree.ConstructBinaryTreefromPreorderandInorderTraversal;

import study.tree.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(
                preorder,
                inorder,
                0,
                preorder.length - 1,
                0,
                inorder.length - 1
        );
    }

    private TreeNode helper(
            int[] preorder, int[] inorder,
            int startPreOrder, int endPreOrder,
            int startInOrder, int endInOrder) {

        int value = preorder[startPreOrder];
        TreeNode root = new TreeNode(value);
        if (startPreOrder == endPreOrder) {
            return root;
        }

        int midIndex = -1;
        for (int i = startInOrder; i <= endInOrder; i++) {
            if (inorder[i] == value) {
                midIndex = i;
            }
        }

        if (midIndex == startInOrder) {
            root.left = null;
        } else {
            int leftStartPre = startPreOrder + 1;
            int leftEndPre = midIndex + startPreOrder - startInOrder;
            int leftStartIn = startInOrder;
            int leftEndIn = midIndex - 1;
            root.left = helper(
                    preorder, inorder,
                    leftStartPre, leftEndPre,
                    leftStartIn, leftEndIn
            );

        }

        if (midIndex == endInOrder) {
            root.right = null;
        } else {
            root.right = helper(
                    preorder, inorder,
                    endPreOrder - endInOrder + midIndex + 1, endPreOrder,
                    midIndex + 1, endInOrder
            );
        }

        return root;
    }
}