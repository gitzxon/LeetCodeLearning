package study.array.MaxTree

import org.junit.Test
import study.tree.toList

class SolutionTest {

    @Test
    fun generateMaxTree() {
        //        34512
        val treeNode = Solution().generateMaxTree(intArrayOf(3, 4, 5, 1, 2))
        println("treeNode List  = ${treeNode.toList()}")
    }
}