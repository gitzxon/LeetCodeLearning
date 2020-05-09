package study.math.PerfectSquares

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun numSquares() {
        assertEquals(3, Solution().numSquares(12))
        assertEquals(2, Solution().numSquares(13))
    }
}