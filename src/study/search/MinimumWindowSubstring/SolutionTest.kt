package study.search.MinimumWindowSubstring

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    @Test
    fun t1() {
        assertEquals(
                "BANC",
                Solution().minWindow("ADOBECODEBANC","ABC")
        )
    }

    @Test
    fun t2() {
        val s = "ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country"
        val t = "ask_country"
        Solution().minWindow(s, t)
    }

    @Test
    fun t3() {
        val s = "a"
        val t = "a"
        Solution().minWindow(s, t)
    }

    @Test
    fun t4() {
        val s = "a"
        val t = "b"
        Solution().minWindow(s, t)
    }
}
