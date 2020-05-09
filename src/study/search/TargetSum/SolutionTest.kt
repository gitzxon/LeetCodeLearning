package study.search.TargetSum

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun findTargetSumWays() {
        val result = Solution().findTargetSumWays(
                intArrayOf(1, 1, 1, 1, 1),
                3
        )
        println("result = ${result}")
        assertEquals(
                5,
                result
        )
    }
}