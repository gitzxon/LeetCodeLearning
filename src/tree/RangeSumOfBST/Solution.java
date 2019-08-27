package tree.RangeSumOfBST;

import tree.TreeNode;

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

        if (root.value >= mMin && root.value <= mMax) {
            mSum += root.value;
            performDFS(root.left);
            performDFS(root.right);
        } else if (root.value < mMin) {
            performDFS(root.right);
        } else { //root.val > mMax
            performDFS(root.left);
        }
    }
}