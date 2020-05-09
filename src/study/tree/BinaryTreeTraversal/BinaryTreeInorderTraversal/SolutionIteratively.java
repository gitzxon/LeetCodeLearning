package study.tree.BinaryTreeTraversal.BinaryTreeInorderTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * iteratively
 */
public class SolutionIteratively {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || stack.size() != 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    /**
     * new solution 一个统一的思路
     *
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            LinkedList<Integer> resultContainer = new LinkedList<>();

            TreeNode cur = root;

            while (cur != null || !stack.empty()) {

                if (cur != null) {

                    stack.push(cur);
                    cur = cur.left;

                } else {
                    cur = stack.pop();
                    resultContainer.add(cur.val);
                    cur = cur.right;
                }
            }

            return resultContainer;
        }
    }

}
