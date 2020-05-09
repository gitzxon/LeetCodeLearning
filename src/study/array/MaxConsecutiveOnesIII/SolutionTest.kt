package study.array.MaxConsecutiveOnesIII

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun longestOnes() {
        val result = Solution().longestOnes(
                intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2
        )
        println("result = ${result}")


    }

    @Test
    fun test1() {
        assertEquals(
                10,
                Solution().longestOnes(
                        intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3)
        )
    }

    @Test
    fun test2() {
        assertEquals(
                25,
                Solution().longestOnes(
                        intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1),
                        8
                )
        )
    }
}