package study.tree.ConvertSortedArrayToBinarySearchTree;

import study.tree.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length);
    }

    public TreeNode helper(int[] nums, int start, int end) {

        if (start >= end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}