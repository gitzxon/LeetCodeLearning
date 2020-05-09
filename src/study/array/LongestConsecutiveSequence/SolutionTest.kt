package study.array.LongestConsecutiveSequence

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun longestConsecutive() {
        assertEquals(
                4,
                Solution().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))
        )
    }
}