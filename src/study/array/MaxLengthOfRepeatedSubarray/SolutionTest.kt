package study.array.MaxLengthOfRepeatedSubarray

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun findLength() {
        assertEquals(
                3,
                Solution().findLength(
                        intArrayOf(1, 2, 3, 2, 1),
                        intArrayOf(3, 2, 1, 4, 7)
                )
        )
    }
}