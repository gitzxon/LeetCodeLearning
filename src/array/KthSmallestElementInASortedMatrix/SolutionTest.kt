package array.KthSmallestElementInASortedMatrix

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun kthSmallest() {
        val matrix = arrayOf(
                intArrayOf( 1,  5,  9),
                intArrayOf(10, 11, 13),
                intArrayOf(12, 13, 15)
        )
        val result = Solution().kthSmallest(matrix, 8)
        println("result = ${result}")
    }
}