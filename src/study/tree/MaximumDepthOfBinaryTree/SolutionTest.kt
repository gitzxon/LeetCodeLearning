package study.tree.MaximumDepthOfBinaryTree

import org.junit.Assert.assertEquals
import org.junit.Test
import study.tree.toTree

class SolutionTest {

    @Test
    fun maxDepth() {
        val treeNode = "[3,9,20,null,null,15,7]".toTree()
        assertEquals(
                3,
                Solution().maxDepth(treeNode)
        )
    }

    @Test
    fun test1() {
        assertEquals(
                0,
                Solution().maxDepth(null)
        )
    }

    @Test
    fun test2() {
        assertEquals(
                1,
                Solution().maxDepth("3".toTree())
        )
    }
}