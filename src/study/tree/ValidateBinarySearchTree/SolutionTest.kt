package study.tree.ValidateBinarySearchTree

import org.junit.Assert.assertEquals
import org.junit.Test
import study.tree.TreeNode
import study.tree.toTreeNode

class SolutionTest {

    @Test
    fun isValidBST() {
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)
        val res = Solution().isValidBST(root)
        assertEquals(true, res)
    }

    @Test
    fun test() {
        val root = TreeNode(5)
        root.left = TreeNode(1)
        root.right = TreeNode(4)
        root.right.left = TreeNode(3)
        root.right.right = TreeNode(6)
        assertEquals(false, Solution().isValidBST(root))
    }

    @Test
    fun test1() {
        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(5)
        root.left.left = TreeNode(0)
        root.left.right = TreeNode(2)
        root.right.left = TreeNode(4)
        root.right.right = TreeNode(6)
        assertEquals(
                true,
                Solution().isValidBST(root)
        )
    }

    @Test
    fun test2() {
        // [3,1,5,0,2,4,6,null,null,null,3]

        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(5)
        root.left.left = TreeNode(0)
        root.left.right = TreeNode(2)
        root.right.left = TreeNode(4)
        root.right.right = TreeNode(6)
        assertEquals(
                true,
                Solution().isValidBST(root)
        )
    }

    @Test
    fun test3() {
        val root = 10.toTreeNode()
        root.left = 5.toTreeNode()
        root.right = 15.toTreeNode()
        root.right.left = 6.toTreeNode()
        root.right.right = 20.toTreeNode()

        assertEquals(
                false,
                Solution().isValidBST(root)
        )
    }
}