package array.ShortestSubarrayWithSumAtLeastK

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
                Solution().shortestSubarray(intArrayOf(1,2), 4)
        )

        assertEquals(
                3,
                Solution().shortestSubarray(intArrayOf(2,-1,2), 3)
        )
    }
}