package study.math.ValidPerfectSquare.Newton

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SolutionTest {

    @Test
    fun isPerfectSquare() {
        assertTrue(
                Solution().isPerfectSquare(16)
        )
    }

    @Test
    fun t1() {
        assertFalse(
                Solution().isPerfectSquare(3)
        )
    }
}