package study.tree.FlaternBinaryTreeToLinkedList

import org.junit.Test
import study.tree.toTree

class SolutionTest {

    @Test
    fun flatten() {
        val tree = "[1,2,5,3,4,null,6]".toTree()
        Solution().flatten(tree)

    }
}