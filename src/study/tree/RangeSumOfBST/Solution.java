package study.tree.RangeSumOfBST;

import study.tree.TreeNode;

class Solution {

    private int mMin;
    private int mMax;
    private int mSum;

    public int rangeSumBST(TreeNode root, int leftValue, int rightValue) {

        mMin = leftValue;
        mMax = rightValue;
        mSum = 0;
        performDFS(root);
        return mSum;
    }

    private void performDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val >= mMin && root.val <= mMax) {
            mSum += root.val;
            performDFS(root.left);
            performDFS(root.right);
        } else if (root.val < mMin) {
            performDFS(root.right);
        } else { //root.val > mMax
            performDFS(root.left);
        }
    }
}