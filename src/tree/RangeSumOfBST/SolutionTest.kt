package tree.RangeSumOfBST

import org.junit.Test
import tree.toList
import tree.toTree

class SolutionTest {

    @Test
    fun rangeSumBST() {
        // Input: root = [10,5,15,3,7,null,18], L = 7, R = 15

        val root = "[10,5,15,3,7,null,18]".toTree()
        println(root)
        val list = "[10,5,15,3,7,null,18]".split(",", "[", "]").filter { it.isNotEmpty() }
        val equals = list.toTypedArray() contentEquals root.toList().toTypedArray()
        assert(equals)

    }
}