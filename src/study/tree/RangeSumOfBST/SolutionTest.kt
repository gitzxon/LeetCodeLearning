package study.tree.RangeSumOfBST

import org.junit.Test
import study.tree.toTree
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun rangeSumBST() {
        // Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
        val input = "[10,5,15,3,7,null,18]"
        val root = input.toTree()
        assertEquals(
                32,
                Solution().rangeSumBST(root, 7, 15)
        )

    }

    @Test
    fun test1() {
        assertEquals(
                23,
                Solution().rangeSumBST("[10,5,15,3,7,13,18,1,null,6]".toTree(), 6, 10)
        )
    }
}