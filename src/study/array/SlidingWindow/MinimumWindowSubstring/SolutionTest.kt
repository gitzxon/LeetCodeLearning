package study.array.SlidingWindow.MinimumWindowSubstring

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun minWindow() {
        assertEquals(
                "BANC",
                Solution().minWindow("ADOBECODEBANC", "ABC")
        )
    }
}