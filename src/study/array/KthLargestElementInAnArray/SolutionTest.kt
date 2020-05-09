package study.array.KthLargestElementInAnArray

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun findKthLargest() {
        assertEquals(
                5,
                Solution().findKthLargest(
                        intArrayOf(3, 2, 1, 5, 6, 4),
                        2)
        )
    }

    @Test
    fun test1() {
        assertEquals(
                4,
                Solution().findKthLargest(
                        intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6),
                        4)
        )
    }

    @Test
    fun test2() {
        assertEquals(-1,
                Solution().findKthLargest(
                        intArrayOf(-1, 2, 0), 3
                ))
    }

    @Test
    fun test3() {
        assertEquals(0,
                Solution().findKthLargest(
                        intArrayOf(-1, 2, 0), 2
                ))
    }
}