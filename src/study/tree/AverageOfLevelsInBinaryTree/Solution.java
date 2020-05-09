package study.tree.AverageOfLevelsInBinaryTree;

import study.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int count = queue.size();
            long sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add((double) sum / (double) count);

        }

        return result;
    }

}