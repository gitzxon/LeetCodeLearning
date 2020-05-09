package study.array.MedianOfTwoSortedArrays.mine

import org.junit.Assert
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

    @Test
    fun test3() {
        helper(
                (-1).toDouble(),
                intArrayOf(3),
                intArrayOf(-2, -1))
    }

    @Test
    fun test4() {
        helper(
                (3.5).toDouble(),
                intArrayOf(2,3,4,5,6),
                intArrayOf(1))
    }

    private fun helper(
            expected: Double,
            nums1: IntArray,
            nums2: IntArray
    ) {
        Assert.assertEquals(
                expected,
                Solution().findMedianSortedArrays(
                        nums1, nums2
                ),
                0.0000000000000001
        )
    }
}