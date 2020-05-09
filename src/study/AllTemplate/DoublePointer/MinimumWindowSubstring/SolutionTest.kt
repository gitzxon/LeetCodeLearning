package study.AllTemplate.DoublePointer.MinimumWindowSubstring

import org.junit.Test

class SolutionTest {
    @Test
    fun minWindow() {
        val result = Solution().minWindow(
                "ADOBECODEBANC",
                "ABC"
        )
        println("result = ${result}")
    }
}