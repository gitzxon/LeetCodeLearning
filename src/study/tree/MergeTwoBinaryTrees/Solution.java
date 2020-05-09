package study.tree.MergeTwoBinaryTrees;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return performMergeTrees(t1, t2, null);
    }

    private TreeNode performMergeTrees(TreeNode t1, TreeNode t2, TreeNode t3) {
        if (t1 == null && t2 == null) {
            return null;
        }
        else if (t1 == null) {
            return performMergeTrees(t2, t1, t3);
        }

        TreeNode left;
        TreeNode right;
        if (t2 == null) {
            left = performMergeTrees(t1.left, null, null);
            right = performMergeTrees(t1.right, null, null);
        } else {
            left = performMergeTrees(t1.left, t2.left, null);
            right = performMergeTrees(t1.right, t2.right, null);
        }

        if (t3 == null) {
            t3 = new TreeNode(0);
        }
        int val = t1.val;
        if (t2 != null) {
            val += t2.val;
        }

        t3.val = val;
        t3.left = left;
        t3.right = right;

        return t3;
    }
}