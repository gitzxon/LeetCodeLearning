package study.dp.CountingBits

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    @Test
    fun countBits() {
        helper(5)
    }

    fun helper(num: Int) {
        assertArrayEquals(
                intArrayOf(0,1,1,2,1,2),
                Solution().countBits(num)
        )
    }
}