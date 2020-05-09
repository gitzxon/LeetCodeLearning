package study.misc.ShortestUnsortedContinuousSubarray

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun findUnsortedSubarray() {
        assertEquals(
                5,
                Solution().findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15))
        )

        assertEquals(
                0,
                Solution().findUnsortedSubarray(intArrayOf(1, 2, 3, 4))
        )


        assertEquals(
                4,
                Solution().findUnsortedSubarray(intArrayOf(4,3,2,1))
        )
    }
}