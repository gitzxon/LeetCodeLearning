package study.array.MedianOfTwoSortedArrays

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun test1() {
        helper(2.0, intArrayOf(1, 3), intArrayOf(2))

    }

    @Test
    fun test2() {
        helper(
                2.5,
                intArrayOf(1, 2),
                intArrayOf(3, 4))
    }

    private fun helper(
            expected: Double,
            nums1: IntArray,
            nums2: IntArray
    ) {
        assertEquals(
                expected,
                Solution().findMedianSortedArrays(
                        nums1, nums2
                ),
                0.0000000000000001
        )
    }
}