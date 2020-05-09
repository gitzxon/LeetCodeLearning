package study.array.FindFirstAndLastPosition

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun searchRange() {
        val result = Solution().searchRange(
                intArrayOf(5,7,7,8,8,10),
                8
        )
        assertArrayEquals(
                intArrayOf(3,4),
                result
        )
    }
}