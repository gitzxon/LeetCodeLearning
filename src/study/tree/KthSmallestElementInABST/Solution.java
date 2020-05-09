package study.tree.KthSmallestElementInABST;

import study.tree.TreeNode;

import java.util.PriorityQueue;

class Solution {

    int k;

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestSafe(root, k);
    }

    public Integer kthSmallestSafe(TreeNode root, int k) {

        this.k = k;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        inorderDfs(root, priorityQueue);
        int i = 0;
        Integer res = Integer.MAX_VALUE;
        while (i < k) {
            if (priorityQueue.isEmpty()) {
                res = null;
                break;
            } else {
                res = priorityQueue.poll();
            }
            i += 1;
        }

        return res;

    }

    public int inorderDfs(TreeNode root, PriorityQueue<Integer> priorityQueue) {

        if (root == null) return 0;

        if (root.left != null) {
            inorderDfs(root.left, priorityQueue);
        }

        if (priorityQueue.size() == k) {
            return 0;
        }

        priorityQueue.add(root.val);


        if (root.right != null) {
            inorderDfs(root.right, priorityQueue);
        }

        return 0;
    }

}