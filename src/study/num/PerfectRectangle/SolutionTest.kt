package study.num.PerfectRectangle

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun isRectangleCover() {
        val rect = arrayOf(
                intArrayOf(1, 1, 3, 3),
                intArrayOf(3, 1, 4, 2),
                intArrayOf(3, 2, 4, 4),
                intArrayOf(1, 3, 2, 4),
                intArrayOf(2, 3, 3, 4)
        )
        assertEquals(
                true,
                Solution().isRectangleCover(rect))
    }

    @Test
    fun t1() {
        val rect = arrayOf(intArrayOf(0, 0, 4, 1), intArrayOf(7, 0, 8, 2), intArrayOf(6, 2, 8, 3), intArrayOf(5, 1, 6, 3), intArrayOf(4, 0, 5, 1), intArrayOf(6, 0, 7, 2), intArrayOf(4, 2, 5, 3), intArrayOf(2, 1, 4, 3), intArrayOf(0, 1, 2, 2), intArrayOf(0, 2, 2, 3), intArrayOf(4, 1, 5, 2), intArrayOf(5, 0, 6, 1))
        assertEquals(
                true,
                Solution().isRectangleCover(rect))
    }
}