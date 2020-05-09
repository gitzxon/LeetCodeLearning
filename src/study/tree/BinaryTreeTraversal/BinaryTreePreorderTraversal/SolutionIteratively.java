package study.tree.BinaryTreeTraversal.BinaryTreePreorderTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolutionIteratively {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            Stack<TreeNode> stack = new Stack();
            List<Integer> resultContainer = new LinkedList<>();
            TreeNode cur = root;

            while (cur != null || !stack.isEmpty()){

                if (cur != null) {

                    resultContainer.add(cur.val);
                    if (cur.right != null) stack.push(cur.right);
                    cur = cur.left;

                } else {
                    cur = stack.pop();
                }

            }

            return resultContainer;
        }
    }

}
