package study.tree.FlaternBinaryTreeToLinkedList;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        performPreorderTraversal(root, queue);

        TreeNode cur = null;
        while (queue.size() != 0) {
            if (cur == null) {
                cur = queue.poll();
            } else {
                cur.left = null;
                cur.right = queue.poll();
                cur = cur.right;
            }
        }
    }

    private void performPreorderTraversal(TreeNode root, Queue<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.offer(root);
        performPreorderTraversal(root.left, list);
        performPreorderTraversal(root.right, list);
    }

}