package study.tree.BinaryTreeTraversal.BinaryTreeInorderTraversal;

import study.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

class SolutionRecursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        return helper(new LinkedList<>(), root);
    }

    public List<Integer> helper(List<Integer> resultContainer, TreeNode root) {

        if (root == null) {
            return resultContainer;
        } else {
            if (root.left != null) {
                helper(resultContainer, root.left);
            }
            resultContainer.add(root.val);
            if(root.right != null) {
                helper(resultContainer, root.right);
            }
        }

        return resultContainer;

    }

}