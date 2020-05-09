package study.tree.BinaryTreeTraversal.BinaryTreePostorderTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolutionIteratively {

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack();
            LinkedList<Integer> resultContainer = new LinkedList<>();

            TreeNode cur = root;

            while (cur != null || !stack.empty()) {

                if (cur != null) {

                    resultContainer.addFirst(cur.val);
                    if (cur.left != null) {
                        stack.push(cur.left);
                    }
                    cur = cur.right;

                } else {
                    cur = stack.pop();
                }

            }

            return resultContainer;
        }
    }

}
