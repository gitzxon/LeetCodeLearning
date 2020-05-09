package study.tree.PathSum.III

import org.junit.Assert.assertEquals
import org.junit.Test
import study.tree.toTree

class SolutionTest {

    @Test
    fun pathSum() {

        val ret = Solution().pathSum("[10,5,-3,3,2,null,11,3,-2,null,1]".toTree(), 8)
        println("ret = ${ret}")
        assertEquals(3, ret)
    }

    @Test
    fun test1() {
        val ret = Solution().pathSum("[-2,null,-3]".toTree(), -3)
        assertEquals(1, ret)
    }
}