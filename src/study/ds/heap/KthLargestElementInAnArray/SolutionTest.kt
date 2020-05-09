package study.ds.heap.KthLargestElementInAnArray

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun findKthLargest() {
        assertEquals(
                5,
                Solution().findKthLargest(intArrayOf(3,2,1,5,6,4), 2))

        assertEquals(
                4,
                Solution().findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))

    }
}