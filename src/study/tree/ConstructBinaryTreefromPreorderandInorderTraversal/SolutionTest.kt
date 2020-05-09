package study.tree.ConstructBinaryTreefromPreorderandInorderTraversal

import org.junit.Test

class SolutionTest {

    @Test
    fun buildTree() {
        val root = Solution().buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        println(root)
    }

    @Test
    fun t1() {

        Solution().buildTree(
                intArrayOf(1, 2),
                intArrayOf(2, 1)
        )
    }
}