package study.array.LargestRectangleInHistogram

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun largestRectangleArea() {
        assertEquals(
                10,
                Solution().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3))
        )
    }

    @Test
    fun t1() {
        assertEquals(
                4,
                Solution().largestRectangleArea(intArrayOf(2, 4))
        )
    }

    @Test
    fun t2() {
        assertEquals(
                2,
                Solution().largestRectangleArea(intArrayOf(1, 1))
        )
    }

    @Test
    fun t3() {
        assertEquals(3,
                Solution().largestRectangleArea(intArrayOf(2, 1, 2))
        )
    }
}