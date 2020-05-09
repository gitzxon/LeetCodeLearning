package study.tree.LowestCommonAncestorOfABinaryTree

import org.junit.Test

import study.tree.TreeNode

class SolutionTest {

    @Test
    fun lowestCommonAncestor() {

        val root = TreeNode(3)
        root.left = TreeNode(5)
        root.right = TreeNode(1)

        root.left.left = TreeNode(6)
        root.left.right = TreeNode(2)

        root.left.right.left = TreeNode(7)
        root.left.right.right = TreeNode(4)

        root.right.left = TreeNode(0)
        root.right.right = TreeNode(8)

        var p = root.left
        var q = root.right
        Solution().lowestCommonAncestor(root, p, q)

        p = root.left
        q = root.left.right.right
        Solution().lowestCommonAncestor(root, p, q)
    }
}