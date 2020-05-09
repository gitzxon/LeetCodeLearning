package study.tree.AverageOfLevelsInBinaryTree

import org.junit.Test
import study.tree.toTreeNode

class SolutionTest {

    @Test
    fun averageOfLevels() {
        val root = 3.toTreeNode()
        root.left = 9.toTreeNode()
        root.right = 20.toTreeNode()
        root.right.left = 15.toTreeNode()
        root.right.right = 7.toTreeNode()


        val result = Solution().averageOfLevels(root)
        result.forEach { println("it = ${it}") }

    }
}