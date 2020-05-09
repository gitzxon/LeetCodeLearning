package study.array.RectangleOverlap

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SolutionTest {

    @Test
    fun isRectangleOverlap() {
        assertTrue(Solution().isRectangleOverlap(
                intArrayOf(0, 0, 2, 2),
                intArrayOf(1, 1, 3, 3)
        ))

        assertFalse(
                Solution().isRectangleOverlap(
                        intArrayOf(0, 0, 1, 1),
                        intArrayOf(1, 0, 2, 1)
                )
        )
    }
}