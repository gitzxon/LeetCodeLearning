package tree.BinaryTreeTraversal.BinaryTreePreorderTraversal;

import tree.TreeNode;

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

                    resultContainer.add(cur.value);
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
