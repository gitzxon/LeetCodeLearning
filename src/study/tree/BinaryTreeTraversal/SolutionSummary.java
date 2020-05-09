package study.tree.BinaryTreeTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class SolutionSummary {


    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack();
        List<Integer> resultContainer = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            if (cur != null) {

                resultContainer.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;

            } else {
                cur = stack.pop();
            }

        }

        return resultContainer;
    }

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


    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        LinkedList<Integer> resultContainer = new LinkedList<>();

        TreeNode cur = root;

        while (cur != null || !stack.empty()) {

            if (cur != null) {

                resultContainer.addFirst(cur.val);
                stack.push(cur.left);
                cur = cur.right;

            } else {
                cur = stack.pop();
            }

        }

        return resultContainer;
    }
}
