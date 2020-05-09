package study.tree.BinaryTreeTraversal.BinaryTreePostorderTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SolutionRecursive {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            return helper(new LinkedList<Integer>(), root);
        }

        public List<Integer> helper(List<Integer> resultContainer, TreeNode root) {
            if (root == null) {
                return resultContainer;
            }

            if (root.left != null) {
                helper(resultContainer, root.left);
            }

            if (root.right != null) {
                helper(resultContainer, root.right);
            }

            resultContainer.add(root.val);

            return resultContainer;
        }
    }
}
