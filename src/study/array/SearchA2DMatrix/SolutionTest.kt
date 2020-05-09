package study.array.SearchA2DMatrix

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SolutionTest {

    @Test
    fun searchMatrix() {
        val matrix = arrayOf(
            intArrayOf(1,   4,  7, 11, 15),
            intArrayOf(2,   5,  8, 12, 19),
            intArrayOf(3,   6,  9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )
        assertTrue(
                Solution().searchMatrix(matrix, 5)
        )
        assertFalse(
                Solution().searchMatrix(matrix, 20)
        )
    }
}