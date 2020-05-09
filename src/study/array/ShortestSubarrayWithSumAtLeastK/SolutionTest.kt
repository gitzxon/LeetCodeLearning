package study.array.ShortestSubarrayWithSumAtLeastK

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun shortestSubarray() {
        assertEquals(
                1,
                Solution().shortestSubarray(intArrayOf(1), 1)
        )

        assertEquals(
                -1,
                Solution().shortestSubarray(intArrayOf(1, 2), 4)
        )


    }

    @Test
    fun test1() {
        assertEquals(
                3,
                Solution().shortestSubarray(intArrayOf(2, -1, 2), 3)
        )
    }

    @Test
    fun test2() {
        assertEquals(
                3,
                Solution().shortestSubarray(intArrayOf(84, -37, 32, 40, 95), 167))
    }

    @Test
    fun test3() {
        assertEquals(
                2,
                Solution().shortestSubarray(intArrayOf(
                        17,85,93,-45,-21
                ), 150)
        )
    }

    @Test
    fun test4() {
        assertEquals(
                2,
                Solution().shortestSubarray(intArrayOf(
                        56,-21,56,35,-9
                ), 61)
        )
    }
}