package study.array.FirstMissingPositive

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun firstMissingPositive() {
        assertEquals(3,
                Solution().firstMissingPositive(intArrayOf(1, 2, 0)))

        assertEquals(2,
                Solution().firstMissingPositive(intArrayOf(3, 4, 1, -1)))

        assertEquals(
                1,
                Solution().firstMissingPositive(intArrayOf(7,8,9,11,12))
        )
    }

    @Test
    fun test1() {
        assertEquals(
                2,
                Solution().firstMissingPositive(
                        intArrayOf(3,4,-1,1)
                )
        )
    }
}